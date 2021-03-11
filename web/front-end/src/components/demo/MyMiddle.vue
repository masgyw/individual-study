<template>
    <div>
        <h1>中部...</h1>
        <div>
            {{str}}
            <br>
            {{msg}}
        </div>
        <hr>
    </div>
</template>

<script>
    import VueEvent from '@/components/model/VueEvent.js';

    export default {
        name: "my-middle",
        data: function () {
            return {
                msg: "",
                str: "我是谁？我在那？"
            }
        },
        mounted: function () {
            var vx = this;
            VueEvent.$on("dataEvt", function (data) {
                console.log("middle:" + data);
                vx.msg = data;
                // this.msg = data; // this 已经不是全局Vue
            });
        }
    }
</script>
<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
</style>