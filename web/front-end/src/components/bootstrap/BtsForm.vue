<template>
    <div class="container">
        <h2>全局CSS样式--表单</h2>
        <h3>形式一：默认表单</h3>
        <form action="#">
            <div class="form-group">
                <label for="uname" class="control-label">用户名</label>
                <input type="text" class="form-control" id="uname" />
                <span class="help-block">6-8字母</span>
            </div>
            <div class="form-group">
                <label for="passwd" class="control-label">密码</label>
                <input type="password" class="form-control" id="passwd" />
                <span class="help-block">6-8字母</span>
            </div>
            <div class="form-group">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" />七天免密登录
                    </label>
                </div>
            </div>
            <div class="form-group">
                <input type="submit" value="登录" class="btn btn-success" />
                <input type="reset" value="取消" class="btn btn-warning" />
            </div>
        </form>
        <h3>形式二：行内表单</h3>
        <form action="#" class="form-inline">
            <div class="form-group">
                <label for="unmame1" class="sr-only">用户名</label>
                <input type="text" class="form-control" id="unmame1" placeholder="请输入用户名" />
            </div>
            <div class="form-group">
                <label for="passwd1" class="sr-only">密码</label>
                <input type="password" class="form-control" id="passwd1" placeholder="请输入密码" />
            </div>
            <div class="form-group">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" />七天免密登录
                    </label>
                </div>
            </div>
            <div class="form-group">
                <input type="submit" value="登录" class="btn btn-success" />
                <input type="reset" value="取消" class="btn btn-warning" />
            </div>
        </form>
        <h3>形式三：水平表单</h3>
        <form action="#" class="form-horizontal">
            <div class="form-group">
                <div class="col-sm-2">
                    <label for="unmame1" class="control-label">用户名:</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="unmame1" placeholder="请输入用户名" />
                </div>
                <div class="col-sm-4">
                    <span class="help-block">6-8字母</span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2">
                    <label for="passwd1" class="control-label">密码:</label>
                </div>
                <div class="col-sm-6">
                    <input type="password" class="form-control" id="passwd1" placeholder="请输入密码" />
                </div>
                <div class="col-sm-4">
                    <span class="help-block">6-8字母、数字</span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12 checkbox">
                    <label>
                        <input type="checkbox" />七天免密登录
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-2">
                    <input type="submit" value="登录" class="btn btn-success" />
                    <input type="reset" value="取消" class="btn btn-warning" />
                </div>
            </div>
        </form>
    </div>
</template>

<script>
    export default {

    }
</script>

<style scoped>
</style>