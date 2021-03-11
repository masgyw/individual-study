<template>
    <div>
        <!-- 导航条：包含容器 -->
        <div class="navbar navbar-default">
            <div class="container">
                <!-- 第一部分：导航条头部=品牌logo+ -->
                <div class="navbar-header">
                    <!-- 左侧图标 -->
                    <a class="navbar-brand" href="#">导航条</a>
                    <!-- 汉堡菜单默认不可见 -->
                    <a href="#" class="navbar-toggle">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                </div>
                <!-- 第二部分：可折叠的内容 -->
                <div class="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#">首页</a></li>
                        <li><a href="#">新闻</a></li>
                        <li class="dropdown">
                            <!-- 触发元素添加：data-toggle -->
                            <a data-toggle="dropdown">产品大全<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">手机</a></li>
                                <li><a href="#">相机</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- 导航条中的超链接 -->
                <a class="navbar-right navbar-link navbar-text" href="#">登录</a>
                <!-- 导航条中的文本 -->
                <a class="navbar-right navbar-text" href="#">|</a>
                <a class="navbar-right btn btn-success navbar-btn" href="#">注册</a>
                <!-- 导航条中的表单 -->
                <form action="#" class="navbar-right navbar-form">
                    <div class="form-group">
                        <label for="kw" class="sr-only">产品搜索</label>
                        <input type="text" class="form-control" id="kw" />
                    </div>
                </form>
                <!-- 导航条中的文本 -->
            </div>
        </div>

        <!-- 导航 -->
        <div class="container">
            
        </div>


        <!-- 导航条：包含容器 -->
        <div class="navbar navbar-inverse navbar-fixed-bottom hidden">
            <div class="container">
                <!-- 第一部分：导航条头部=品牌logo+ -->
                <div class="navbar-header">
                    <!-- 左侧图标 -->
                    <a class="navbar-brand" href="#">导航条</a>
                    <!-- 汉堡菜单默认不可见 -->
                    <a href="#" class="navbar-toggle">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                </div>
                <!-- 第二部分：可折叠的内容 -->
                <div class="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#">首页</a></li>
                        <li class="active"><a href="#">新闻</a></li>
                        <li class="dropdown">
                            <!-- 触发元素添加：data-toggle -->
                            <a data-toggle="dropdown">产品大全<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">手机</a></li>
                                <li><a href="#">相机</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- 导航条中的超链接 -->
                <a class="navbar-right navbar-link navbar-text" href="#">登录</a>
                <!-- 导航条中的文本 -->
                <a class="navbar-right navbar-text" href="#">|</a>
                <a class="navbar-right btn btn-success navbar-btn" href="#">注册</a>
                <!-- 导航条中的表单 -->
                <form action="#" class="navbar-right navbar-form">
                    <div class="form-group">
                        <label for="kw" class="sr-only">产品搜索</label>
                        <input type="text" class="form-control" id="kw" />
                    </div>
                </form>
                <!-- 导航条中的文本 -->
            </div>
        </div>
    </div>
</template>

<script>
    export default {

    }

    // 必须这样写
    jQuery(function () {
        console.log("jquery init method...");
    });


</script>

<style scoped>
    /* @import 引入自定义css */
</style>