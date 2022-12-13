<template>
    <div>
        <div class="hello">Hello {{ who }}</div>
        <!-- <el-button>确认</el-button> -->
        <h4>custom comp</h4>
        <my-component></my-component>
    </div>
</template>
 
<script>
module.exports = {
    components: {
        'my-component': httpVueLoader('views/my-component.vue')
    },

    data: function () {
        return {
            who: 'world'
        }
    }
}
</script>
 
<style>
.hello {
    background-color: #ffe;
}
</style>