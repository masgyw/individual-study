<template>
    <div class="container">
        <h2>组件--下拉菜单</h2>
        <h3>下拉菜单dropdown</h3>
        <h4>最简单的下拉菜单--自定义属性-配合js实现</h4>
        <div class="dropdown">
            <a href="#" data-dochange="dochange" id="prod-list">产品大全</a>
            <ul class="dropdown-menu">
                <li><a href="#">冰箱1</a></li>
                <li><a href="#">冰箱2</a></li>
                <li><a href="#">冰箱3</a></li>
                <li><a href="#">冰箱4</a></li>
                <li><a href="#">冰箱5</a></li>
                <li><a href="#">冰箱6</a></li>
                <li><a href="#">冰箱7</a></li>
            </ul>
        </div>
        <h4>最简单的下拉菜单--使用BootStrap.js</h4>
        <div class="dropdown">
            <a href="#" data-toggle="dropdown" id="prod-list" class="btn btn-default">产品大全
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="#">冰箱1</a></li>
                <li><a href="#">22</a></li>
                <li><a href="#">33</a></li>
                <li><a href="#">44</a></li>
            </ul>
        </div>
        <h4>稍复杂的下拉菜单--使用BootStrap.js</h4>
        <div class="dropdown">
            <a href="#" data-toggle="dropdown" id="prod-list" class="btn btn-default">产品大全
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li class="dropdown-header" ><a href="#">电器类</a></li>
                <li><a href="#">冰箱</a></li>
                <li><a href="#">电视</a></li>
                <li class="dropdown-header"><a href="#">图书类</a></li>
                <li><a href="#">西游记</a></li>
            </ul>
        </div>
        <!-- <button id="btn">dd</button> -->
    </div>
</template>

<script>
    export default {

    }

    // 必须这样写
    jQuery(function () {
        console.log("jquery init method...");
        /* $("#btn").click(function() {
            alert("btn")
        });
        */
        $("[data-dochange='dochange']").click(function (evt) {
            evt.preventDefault();
            alert("123")
            $(this).siblings('.dropdown-menu').toggle();
        });
    });


</script>

<style scoped>
    /* @import 引入自定义css */
</style>