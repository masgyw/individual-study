<template>
    <!-- 导航 -->
    <div class="container">
        <h2>组件--导航</h2>
        <h3>形式一：页签导航</h3>
        <ul class="nav nav-tabs">
            <li><a data-toggle="tab" href="#">十元套餐</a></li>
            <li class="active"><a data-toggle="tab" href="1">三十元套餐</a></li>
            <li><a data-toggle="tab" href="1">二十元套餐</a></li>
        </ul>
        <h3>形式二：胶囊式导航</h3>
        <ul class="nav nav-pills">
            <li><a data-toggle="tab" href="1">十元套餐</a></li>
            <li class="active"><a data-toggle="tab" href="1">三十元套餐</a></li>
            <li><a data-toggle="tab" href="1">二十元套餐</a></li>
        </ul>

        <h3>组件--按钮组</h3>
        <div class="btn-group">
            <a class="btn btn-default"><span class="glyphicon glyphicon-backward"></span></a>
            <a class="btn btn-default"><span class="glyphicon glyphicon-pause"></span></a>
            <a class="btn btn-default"><span class="glyphicon glyphicon-play"></span></a>
            <a class="btn btn-default"><span class="glyphicon glyphicon-forward"></span></a>
        </div>
        <h3>组件--按钮组--垂直</h3>
        <div class="btn-group-vertical">
            <a class="btn btn-default"><span class="glyphicon glyphicon-backward"></span></a>
            <a class="btn btn-default"><span class="glyphicon glyphicon-pause"></span></a>
            <a class="btn btn-default"><span class="glyphicon glyphicon-play"></span></a>
            <a class="btn btn-default"><span class="glyphicon glyphicon-forward"></span></a>
        </div>

        <h3>组件--警告框</h3>
        <div class="alert alert-danger">
            <span class="glyphicon glyphicon-alert"></span>
            <p>
                您的浏览器版本太低！
            </p>
        </div>
        <div class="alert alert-info" data-dismiss="alert">
            <span class="close">&times;</span>
            <h4 class="glyphicon glyphicon-alert">
                通知
            </h4>
            <p>
                您的浏览器版本太低！
            </p>
        </div>

        <h3>组件--进度条</h3>
        <div class="progress ">
            <div class="progress-bar progress-bar-danger" style="width:10%;">10%</div>
        </div>
        <div class="progress ">
            <div class="progress-bar progress-bar-warning" style="width:20%;">20%</div>
        </div>
        <h3>带条纹</h3>
        <div class="progress ">
            <div class="progress-bar progress-bar-danger progress-bar-striped" style="width:40%;">40%</div>
        </div>
        <h3>动态带条纹</h3>
        <div class="progress ">
            <div class="progress-bar progress-bar-danger progress-bar-striped active" style="width:40%;">40%</div>
        </div>

        <h3>缩略图</h3>
        <div class="thumbnail">
            <img src="static/img/tiger.jpg" class="img-rounded" />
            <div class="caption">
                <h4>一只老虎</h4>
                <p>黄色</p>
                <button class="btn btn-default">查看</button>
            </div>
        </div>

        <h3>面板</h3>
        <div class="panel panel-default">
            <div class="panel-heading">面板头部</div>
            <div class="panel-body">面板中部</div>
            <div class="panel-footer">面板尾部</div>
        </div>

        <h3>展开/收起目标对象插件</h3>
        <a href="#my-target" data-toggle="collapse">展开/收起</a>
        <button data-target="#my-target" data-toggle="collapse">展开/收起</button>
        <div id="my-target" class="collapse in">
            <ul>
                <li>js</li>
                <li>css</li>
                <li>html</li>
            </ul>
        </div>

        <h3>手风琴</h3>
        <!-- 最外层父元素 面板组 -->
        <div class="panel-group" id="pgroup">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <!-- data-parent="#pgroup" 指定属于同一个面板组，同一时间只能一个面板显示 -->
                    <a href="#xyz" data-toggle="collapse" data-parent="#pgroup">西游记</a>
                </div>
                <div class="collapse in panel-collapse" id="xyz">
                    <div class="panel-body">显示示例代码</div>
                </div>
            </div>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <a href="#rr" data-toggle="collapse" data-parent="#pgroup">读书</a>
                </div>
                <div class="collapse panel-collapse" id="rr">
                    <div class="panel-body">
                        示例代码
                    </div>
                </div>
            </div>
        </div>

    </div>

</template>

<script>
    export default {

    }

</script>

<style scoped>
    /* @import 引入自定义css */
</style>