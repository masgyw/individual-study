<template>
    <div class="container">
        <h2>全局CSS样式--栅格系统</h2>
        <div class="row">
            <!-- 中屏幕下 1等份 -->
            <div class="col-md-1">1等份</div>
        </div>
        <div class="row">
            <!-- 中屏幕下 2等份 -->
            <div class="col-md-2">2等份</div>
        </div>
        <div class="row">
            <div class="col-md-3">3等份</div>
        </div>
        <div class="row">
            <div class="col-md-4">4等份</div>
        </div>
        <div class="row">
            <div class="col-md-5">5等份</div>
        </div>
        <div class="row">
            <div class="col-md-6">6等份</div>
        </div>
        <div class="row">
            <div class="col-md-7">7等份</div>
        </div>
        <div class="row">
            <div class="col-md-8">8等份</div>
        </div>

        <div class="row">
            <div class="col-md-4">Md-4</div>
            <div class="col-md-4">Md-4</div>
            <div class="col-md-4">Md-4</div>
        </div>
        <h3>一行放置不等宽的多列</h3>
        <div class="row">

        </div>
        <h4>一行分为1：4：1</h4>
        <div class="row">
            <div class="col-md-2 col-md-offset-2">2</div>
            <div class="col-md-6">6</div>
            <div class="col-md-2">2</div>
        </div>

        <h4>适用性问题</h4>
        <div class="row">
            <div class="col-xs-6">xs-6</div>
        </div>
        <div class="row">
            <div class="col-sm-6">sm-6</div>
        </div>
        <div class="row">
            <div class="col-md-6">md-6</div>
        </div>
        <div class="row">
            <div class="col-lg-6">lg-6</div>
        </div>
        <h4>指定不同屏幕占比</h4>
        <div class="row">
            <div class="col-xs-3 col-sm-4 col-md-6 col-lg-9">col-xs-3 col-sm-4 col-md-6 col-lg-9</div>
        </div>
        <h4>列隐藏问题</h4>
        <div class="row">
            <div class="col-xs-3 col-sm-4 col-md-6 col-lg-9">col-xs-3 col-sm-4 col-md-6 col-lg-9</div>
        </div>
    </div>
</template>

<script>
    export default {

    }
</script>

<style scoped>
    div {
        border: 1px solid black;
    }
</style>