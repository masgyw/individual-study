<template>
    <div>
        <p>{{targetUser}}</p>
        <div id="msgContent" class="content">
        </div>
        <div class="input">
            <div class="form-group">
                <label>请输入消息：</label>
                <textarea class="form-control" v-model.lazy="msgBody"></textarea>
                <a class="btn btn-default" @click="doSendMsg">发送</a>
            </div>
        </div>
    </div>
</template>

<script>
    import VueEvent from '@/components/model/VueEvent.js';

    var websocket = null;
    var baseUrl = "ws://localhost:8082/im/websocket/";

    var fromUserId = "";
    var toUserId = "";
    var userInfo = {};

    export default {
        name: "ChatRoom",
        data: function () {
            return {
                targetUser: "TODO",
                msgBody: ""
            }
        },
        components: {
        },
        methods: {
            doSendMsg: function () {
                console.log("msg body:" + this.msgBody);
                var msg = {
                    "userId": fromUserId,
                    "toUserId": toUserId,
                    "content": this.msgBody
                }
                if (websocket.readyState == websocket.OPEN) {
                    websocket.send(JSON.stringify(msg));
                } else {
                    showMessage("消息发送失败..")
                }
                this.msgBody = "";
            },
            getUserInfo: function () {
                // 通过公共vue 传递数据
                VueEvent.$on("chatEvt", function (chatInfo) {
                    // console.log("chatInfo;" + chatInfo);
                    userInfo = JSON.parse(chatInfo);
                });
                if (userInfo) {
                    fromUserId = userInfo.fromUserId;
                    toUserId = userInfo.toUserId;
                    this.targetUser = userInfo.userName;
                }

                // vue-router 传递
                /* fromUserId = this.$route.params.userId;
                toUserId = this.$route.params.toUserId;
                this.targetUser = fromUserId; */
                console.log("from :" + fromUserId + "|" + this.targetUser + " to " + toUserId);
            }
        },
        mounted: function () {
            this.getUserInfo();
            // console.log(">> Chat Room is mounted...");
            connectWsServer();
        },
        beforeRouteLeave(to, from, next) { // vue-router 监听回退事件
            if (websocket) { // 关闭websocket 连接
                websocket.close();
            }
            console.log("beforeRouteLeave");
            const answer = window.confirm('Do you really want to leave? you have unsaved changes!')
            if (answer) {
                next()
            } else {
                next(false)
            }
        }
    }



    function onOpen() {
        console.log("Websocket connect success..")
    }

    function onMessage(evt) {
        console.log("服务器返回的消息：" + evt.data);
        var respData = JSON.parse(evt.data);
        var echoMsg = "";
        if (respData.contentType) {
            echoMsg = "-----" + respData.content + "-----";
        } else {
            echoMsg = respData.sendDateTime + " "
                + respData.userName + ":" + respData.content;
        }
        showMessage(echoMsg);
    }

    function onClose() {
        console.log("websocket connect is closed...");
    }

    function onError() {
        console.log("websocket running error!!");
    }

    function connectWsServer() {
        if ('WebSocket' in window) {
            var wsUrl = baseUrl + fromUserId + "/" + toUserId;
            websocket = new WebSocket(wsUrl);
            websocket.onopen = onOpen;
            websocket.onclose = onClose;
            websocket.onmessage = onMessage;
            websocket.onerror = onError;
            showMessage("连接成功...");
        } else {
            showMessage("当前浏览器不支持 WebSocket");
        }
    }

    function showMessage(content) {
        $("#msgContent").append(content + "<br>");
    }

    window.close = function () {
        if (websocket) {
            websocket.close();
        }
    }
</script>
<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
    .content {
        border: 1px solid black;
        width: 100%;
        height: 300px;
        padding-left: 10px;
        text-align: left;
        overflow-y: scroll;
    }

    textarea {
        border: 1px solid black;
        width: 400px;
        height: 150px;
    }
</style>