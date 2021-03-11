## 常用操作
### 1. 合并几个分支  
git log  查看提交历史  
git rebase -i {commit_id}(6位)  不需要合并的commit的hash值
进入vi模式  
pick：执行该commit  
squash：这个commit会被合并到前一个commit  
fixup：放弃该commit  
wq 保存  
注意：git reabse --abort 丢弃变基操作

### 2. 更新远程分支列表
git remote update origin --prune

### 3. 删除远程文件
参考网站：
1、Git 基础 - 记录每次更新到仓库
https://git-scm.com/book/zh/v1/Git-%E5%9F%BA%E7%A1%80-%E8%AE%B0%E5%BD%95%E6%AF%8F%E6%AC%A1%E6%9B%B4%E6%96%B0%E5%88%B0%E4%BB%93%E5%BA%93
=======================================================================
Git 思想
1、Git stash 暂存
git stash 暂存本地，修改且不想提交的代码
merge 代码完成后，从unstash 中获取到暂存的代码；
2.git commit 到本地仓库

3.merge Request 
1）添加 upstream ，添加主库url
2）选择主库pull 拉取最新的代码

4.代码开发流程
https://blog.csdn.net/xsj_blog/article/details/79198502

5 git merge合并时遇上refusing to merge unrelated histories的解决方案
https://www.cnblogs.com/jinbang/p/8920252.html

6 如何把本地项目上传到Github
https://www.cnblogs.com/shenchanghui/p/7184101.html

7.取消文件git 管理
git rm -r --cached <file/folder>
========================================================================
放弃文件修改
git checkout . #本地所有修改的。没有的提交的，都返回到原来的状态
git stash #把所有没有提交的修改暂存到stash里面。可用git stash pop回复。
git reset --hard HASH #返回到某个节点，不保留修改。
git reset --soft HASH #返回到某个节点。保留修改

1.删除Github上文件，不删除本地文件
git rm -r --cached dir
git commit -m 'delete .settings dir'
git push -u origin master

2.上传本地项目到Github
-- 切到需要上传的项目目录，打开git bash
git init
git status
git add .
git commit -m "commit project"
git remote add origin https://.git
如果远程仓库不为空
git pull --rebase origin master
远程仓库为空
git push -u origin master


3.Fork 同步
与上游项目建立联系
git remote add upstream https://github.com/kdn251/interviews.git
查看状态
git remote -v

git fetch upstream

git checkout master

git merge upstream/master -no-ff	
更新本地fork项目仓库
git push origin master

步骤总结
1 bash进入项目目录
2 git remote add upstream 上游仓库名称.git
3 git checkout master
4 git fetch upstream
5 git merge upstream/master
6 git push origin master

4.Merge 冲突解决
模拟冲突条件：
创建分支 dev
git checkout -b dev
git add readme.txt
git commit -m "AND simple"
git checkout master
git add readme.txt 
git commit -m "& simple"
git merge feature1
修改文件后重新提交
查看分支合并情况
git log --graph --pretty=oneline --abbrev-commit

5.Git 提交文件

git clone http://guanyw@10.145.10.102:1180/guanyw/RongZhiRPA_Backend.git

