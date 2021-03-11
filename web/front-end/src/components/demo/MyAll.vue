<template>
    <div>
        <my-head></my-head>
        <my-middle></my-middle>
        <my-footer></my-footer>
    </div>
</template>

<script>
    import MyHeader from './MyHeader';
    import MyMiddle from './MyMiddle';
    import MyFooter from './MyFooter';

    export default {
        name: "brother",
        data: function () {
            return {
                msg: "外框组件"
            }
        },
        components: {
            "my-head": MyHeader,
            "my-middle": MyMiddle,
            "my-footer": MyFooter
        }
    }
</script>
<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
</style>