<template>
    <div>
        <h1>头部...</h1>
        <button @click="sendMsg">发送给中部</button>
        <hr>
    </div>
</template>

<script>
    import VueEvent from '@/components/model/VueEvent.js';

    export default {
        name: "my-header",
        data: function () {
            return {
                msg: "外框组件"
            }
        },
        methods: {
            sendMsg: function() {
                console.log(">>" + VueEvent);
                VueEvent.$emit("dataEvt", "hello， 老二");
            }
        }
    }
</script>
<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
</style>