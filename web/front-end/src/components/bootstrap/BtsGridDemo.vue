<template>
    <div class="container">
        <div class="row">
            <h1 class="col-md-12">Bootstrap Css Type</h1>
        </div>
        <div class="row">
            <input class="col-md-4 col-md-offset-8" placeholder="搜索" />
        </div>
        <div class="row">
            <div class="col-md-3">
                <ul class="list-unstyled">
                    <li>开始学习</li>
                    <li>推荐文章</li>
                    <li>图书</li>
                    <li>课件</li>
                    <li>文章</li>
                </ul>
            </div>
            <div class="col-md-6">
                <div>
                    <span class="glyphicon glyphicon-warning-sign">警告</span>
                    <p class="text-left">三人行必有我师</p>
                    <p class="text-right">-- 孔子</p>
                </div>
                <div>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>编号</th>
                                <th>名称</th>
                                <th>作者</th>
                                <th>价格</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>B0011</td>
                                <td>西游记</td>
                                <td>施耐庵</td>
                                <td>￥40.5</td>
                            </tr>
                            <tr>
                                <td>B0011</td>
                                <td>西游记</td>
                                <td>施耐庵</td>
                                <td>￥40.5</td>
                            </tr>
                            <tr>
                                <td>B0011</td>
                                <td>西游记</td>
                                <td>施耐庵</td>
                                <td>￥40.5</td>
                            </tr>
                            <tr>
                                <td>B0011</td>
                                <td>西游记</td>
                                <td>施耐庵</td>
                                <td>￥40.5</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <h3>课程推荐</h3>
                <div>
                    <dl>
                        <dt>Html</dt>
                        <dd>html learn</dd>
                        <dt>Python</dt>
                        <dd>python learn</dd>
                        <dt>Java</dt>
                        <dd>java learn</dd>
                    </dl>
                    <h4>知识改变命运</h4>
                    <footer>答问</footer>
                </div>
            </div>
        </div>
        <hr>
        <!-- 典型的错误布局：一行四列 -->

        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-3">关于因特尔
                <ul class="list-unstyled">
                    <li>公司信息</li>
                    <li>投资者关系</li>
                    <li>联系我们</li>
                    <li>新闻发布家</li>
                    <li>网站地图</li>
                    <li>工作</li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3">支持
                <ul class="list-unstyled">
                    <li>支持主页</li>
                    <li>下载中心</li>
                    <li>产品规范</li>
                    <li>保修支持</li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3">法律申明
                <ul class="list-unstyled">
                    <li>使用条款</li>
                    <li>商标</li>
                    <li>隐私条款</li>
                    <li>Cookie</li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3">社交</div>
        </div>
        <hr>
        <!-- 典型的错误布局：一行2列，每列再嵌套一行两列 -->
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        关于因特尔
                        <ul class="list-unstyled">
                            <li>公司信息</li>
                            <li>投资者关系</li>
                            <li>联系我们</li>
                            <li>新闻发布家</li>
                            <li>网站地图</li>
                            <li>工作</li>
                        </ul>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        支持
                        <ul class="list-unstyled">
                            <li>支持主页</li>
                            <li>下载中心</li>
                            <li>产品规范</li>
                            <li>保修支持</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6">
                <div class="row">
                    <div class="col-xs-12 col-sm-6">法律申明
                        <ul class="list-unstyled">
                            <li>使用条款</li>
                            <li>商标</li>
                            <li>隐私条款</li>
                            <li>Cookie</li>
                        </ul>
                    </div>
                    <div class="col-xs-12 col-sm-6">社交</div>
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

</style>