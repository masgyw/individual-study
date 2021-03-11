### 7.1 Git Version Control
#### 7.1.1 Git的分支你们是怎么管理的
主要分为三大分支：master、develop、release  
master：主分支，用于对外部署打包，运行演示  
develop：开发分支，正在开发中的分支提交  
release：每个阶段完成，将develop 合并到release 分支，并打上tag  
关于bug修复：测试只针对release 分支，release 分支的bug 直接在release 分支上修复，修复完成后，合并到develop 分支。