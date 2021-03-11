## 系统安装问题
1. 复制虚拟机镜像.vdi 文件到新的虚拟机，网卡问题  
删除：/etc/udev/rules.d/70-persistent-net.rules
修改：vim /etc/sysconfig/network-scripts/ifcfg-eth0的mac 地址  
重启

2. 修改linux root密码

3. 开机启动图形化界面
systemctl get-default  
graphical.target 代表开机时启动图形化界面  
multi-user.target 代表开机时启动dos界面  
systemctl set-default graphical.target

4. centos7 安装VirtualBox 增强工具
cd /run/media/root/VBox_GAs_6.0.24  
./VBoxLinuxAdditions.run  
若安装出错：
rpm -qa | grep kernel-devel != uname -r  
安装对应的版本：  
yum install -y kernel-devel-3.10.0-514.el7
参考网站：  
http://rpm.pbone.net/index.php3/stat/4/idpl/44990415/dir/scientific_linux_7/com/kernel-devel-3.10.0-862.el7.x86_64.rpm.html  

5. centos7 安装 hack 字体
wget https://github.com/source-foundry/Hack/releases/download/v3.003/Hack-v3.003-ttf.zip
unzip Hack-v3.003-ttf.zip
mkdir /usr/share/fonts/hack-font
cd Hack-v3.003-tff
cp Hack* /usr/share/fonts/hack-font

安装微软开源字体 
wget https://github.com/microsoft/cascadia-code/releases/download/v2009.22/CascadiaCode-2009.22.zip  
unzip CascadiaCode-2009.22.zip  
mkdir /usr/share/fonts/cascadiacode-font

6. linux vscode 修改文件不编译的问题解决  
echo fs.inotify.max_user_watches=524288 | sudo tee -a /etc/sysctl.conf && sudo sysctl -p
给目录加777 权限