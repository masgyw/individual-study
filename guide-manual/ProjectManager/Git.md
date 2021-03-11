# GIT
## 一、基础


## 二、常用操作
### 2.1 取消文件git管理，删除Github上文件，不删除本地文件
git rm -r --cached <file/folder>  
git commit -m 'delete .settings dir'  
git push -u origin master  
### 2.2 合并几次commit  
git log  查看提交历史  
git rebase -i {commit_id}(6位)  不需要合并的commit的hash值
进入vi模式  
pick：执行该commit  
squash：这个commit会被合并到前一个commit  
fixup：放弃该commit  
wq 保存  
注意：git reabse --abort 丢弃变基操作
### 2.3 如何把本地项目上传到Github
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
### 2.4 放弃文件修改，回滚代码
git checkout . #本地所有修改的。没有的提交的，都返回到原来的状态  
git stash #把所有没有提交的修改暂存到stash里面。可用git stash pop回复  
git reset --hard HASH #返回到某个节点，不保留修改  
git reset --soft HASH #返回到某个节点。保留修改
### 2.5 Fork 同步
  1. 与上游项目建立联系  
  git remote add upstream *.git  
  2. 查看状态  
  git remote -v  
  3. git checkout master
  4. git fetch upstream
  5. git merge upstream/master -no-ff	
  6. 更新本地fork项目仓库
  git push origin master

