
[IT: Entry Level Helpdesk (Installing Virtualbox and Server 2016) New Techs Part 1 - YouTube](https://www.youtube.com/watch?v=h7XwFtM938I&list=PLdh13bXVc6-k_u2RPqYAp8R8HtYT_ONht)  
[GitHub - massgravel/Microsoft-Activation-Scripts: Open-source Windows and Office activator featuring HWID, Ohook, TSforge, KMS38, and Online KMS activation methods, along with advanced troubleshooting.](https://github.com/massgravel/Microsoft-Activation-Scripts)   

[GitHub - abbodi1406/KMS\_VL\_ALL\_AIO: Smart Activation Script](https://github.com/abbodi1406/KMS_VL_ALL_AIO)  

```shell
# Open PowerShell Copy and paste then press enter
irm https://get.activated.win | iex
```
## local account details
```
AD domain name: greenhuanglocal
AD server ip: 192.168.0.220

winserver account: greenh47/administrator
password(all account is the same): 123qwe!@#QWE



```

## install winserver 2022
[Windows Server 2022 | Microsoft Evaluation Center](https://www.microsoft.com/en-us/evalcenter/download-windows-server-2022?utm_source=chatgpt.com)   
[Activate Windows Server 2022 Datacenter using DISM | How to activate Windows Server 2022 for Free - YouTube](https://www.youtube.com/watch?v=y4oQvkWH9IU)  
[Windows 2022 guest best practices - Proxmox VE](https://pve.proxmox.com/wiki/Windows_2022_guest_best_practices?utm_source=chatgpt.com)   

```shell
# activation key
dism /online /set-edition:ServerDatacenter /productkey:WX4NM-KYWYW-QJJR4-XV3QB-6VM33 /accepteula
```

## setup active directory
[How to set up Active Directory on a Windows Server - VPSBG.eu](https://www.vpsbg.eu/docs/how-to-set-up-active-directory-on-a-windows-server) 
[IT: Entry Level Helpdesk (Renaming Server 2016 and Installing Active Directory) New Techs Part 2 - YouTube](https://www.youtube.com/watch?v=n43Qcj6m5cE&list=PLdh13bXVc6-k_u2RPqYAp8R8HtYT_ONht&index=2)  
![](../img/windows_lab-20250512.png)

## create shared folder between host and vm

```shell
# virtiofsd is installed on the Proxmox host
apt install virtiofsd

# Create share directory on Proxmox
mkdir -p /srv/virtiofs/shared/winserver

# Add VirtioFS device to your VM (replace VMID=100, path and tag as desired):
qm set 101 --virtiofs shared,path=/srv/virtiofs/shared/winserver

```
or Go to Proxmox GUI. Select Datacenter | Directory Mappings. Click add to create a new mapping.

![](../img/windows_lab-20250515-1.png)
Select VM who will access share folder from Proxmox Host. Select _Hardware | Add | Virtiofs_
![](../img/windows_lab-20250515.png)

## setup static ip for my AD server
go to router portal to check local network setting  
![](../img/windows_lab-20250518.png)
we can find that my win server assign with 192.168.0.143 private ip address
![](../img/windows_lab-20250518-1.png)
![](../img/windows_lab-20250518-2.png)  
[Change IP address of a network adapter - Windows Server | Microsoft Learn](https://learn.microsoft.com/en-us/troubleshoot/windows-server/networking/change-ip-address-network-adapter)  
![](../img/windows_lab-20250518-6.png)
![](../img/windows_lab-20250518-4.png)
we can ping the AD in other device inside the local network
![](../img/windows_lab-20250518-5.png)

## install win 11 on proxmox
[Download Windows 11](https://www.microsoft.com/en-au/software-download/windows11)  
[Windows 11 guest best practices - Proxmox VE](https://pve.proxmox.com/wiki/Windows_11_guest_best_practices)  
[Run WINDOWS 11 on Proxmox Made EASY! - YouTube](https://www.youtube.com/watch?v=YhNH2GpMvBM)  

## join win 11 to AD
[How to Join Windows 11 PC to Windows Server 2022 Domain - YouTube](https://www.youtube.com/watch?v=K7thNKB7v5c)  
[IT: Entry Level Helpdesk (Windows 10, Join PC To domain, RSAT tool, Server Manager) New Techs Part 4 - YouTube](https://www.youtube.com/watch?v=Yoju609xENI&list=PLdh13bXVc6-k_u2RPqYAp8R8HtYT_ONht&index=8)  
[Join a computer to a domain | Microsoft Learn](https://learn.microsoft.com/en-us/windows-server/identity/ad-fs/deployment/join-a-computer-to-a-domain)  
[Create Active Directory Test Environment (Complete Guide) - Active Directory Pro](https://activedirectorypro.com/create-active-directory-test-environment/#lesson-2)  
RSAT simply gives you the **admin consoles** (AD Users & Computers, DNS Manager, DHCP, Group Policy Management, etc.) that normally live on a Windows Server. Installing them on your workstation lets you do day-to-day management from the comfort of a client VM instead of RDP-ing to the DC.RSAT 只是为您提供了通常位于 Windows Server 上的**管理控制台** （AD 用户和计算机、DNS 管理器、DHCP、组策略管理等）。将它们安装在您的工作站上，可以让您轻松地从客户端虚拟机进行日常管理，而无需通过 RDP 连接到 DC。
![](../img/windows_lab-20250518-7.png)

make sure that Any client that should join greenhuang.local have at least one DNS server to AD server  
![](../img/windows_lab-20250518-8.png)
![](../img/windows_lab-20250518-9.png)
![](../img/windows_lab-20250518-10.png)
![](../img/windows_lab-20250522.png)
# set up NTP server in Active Directory
[How to configure NTP server in AD - Microsoft Solutions Hub](https://renanrodrigues.com/how-to-configure-ntp-server-in-ad/) 
The NTP server causes the "clock is not synchronized" message to sometimes appear when syncing with the AD server. 
![](../img/windows_lab-20250525-5.png)
you can see that client side using local clock instead of AD clock or NTP clock. 
![](../img/windows_lab-20250524-3.png)

If the client or DC runs in Proxmox/VMware/Hyper-V, the hypervisor may keep pushing its own (wrong) time: **Proxmox/KVM:** disable “Use local time for RTC”  
![](../img/windows_lab-20250524-5.png)

enable it in group policy 
[How to Set Up an NTP Server Using Group Policy: Step-by-Step Guide](https://serverspace.us/support/help/how-to-set-an-ntp-server-group-policy/) 
![](../img/windows_lab-20250525-3.png) 
we can check on client side that it using AD server's clock.
![](../img/windows_lab-20250525-4.png)

# Implement Group Policy Objects
[Implement Group Policy Objects - Training | Microsoft Learn](https://learn.microsoft.com/en-us/training/modules/implement-group-policy-objects/)  
[Group Policy Management Guide - Active Directory Pro](https://activedirectorypro.com/group-policy-guide/)  

**Group Policy Objects (GPOs)** = A group policy object is a collection of policy settings. A GPO is applied to the domain, or an OU to target users, computers, or the entire domain. You will spend most of your time working with GPs.  
**组策略对象 (GPO)** = 组策略对象是一组策略设置的集合。GPO 应用于域或组织单元 (OU)，以定位用户、计算机或整个域。您将花费大部分时间与组策略对象打交道。

![group policy objects](https://activedirectorypro.com/wp-content/uploads/2022/09/group-policy-objects.webp "group-policy-objects")

**Group Policy Management Console (GPMC)** = This is the management console used to manage group policy and GPOs. This is installed on the Active Directory server but can also be added to other computers by [installing the RSAT tools](https://activedirectorypro.com/install-rsat-remote-server-administration-tools-windows-10/).  
**组策略管理控制台 (GPMC)** = 这是用于管理组策略和 GPO 的管理控制台。它安装在 Active Directory 服务器上，但也可以通过[安装 RSAT 工具](https://activedirectorypro.com/install-rsat-remote-server-administration-tools-windows-10/)将其添加到其他计算机。

**Local Group Policy** = Local group policies are policies that apply to a single computer and are managed locally on a computer. You can access the local GPO with the gpedit.msc console. These policies apply to only the computer you edit them on. Domain policies take precedence over local policies.  
**本地组策略** = 本地组策略是应用于单台计算机并在该计算机上本地管理的策略。您可以使用 gpedit.msc 控制台访问本地组策略 (GPO)。这些策略仅适用于您在其上编辑的计算机。域策略优先于本地策略。

**Domain Group Policy** (DGP) = Domain group policies are managed centrally and can be applied to multiple computers and users. DGPs will be the focus of this guide.  
**域组策略** (DGP) = 域组策略集中管理，可应用于多台计算机和用户。本指南将重点介绍 DGP。

**User Configuration Policies** = Each GPO has a user configuration and computer configuration section. The User configuration policies only apply to users.  
**用户配置策略** = 每个 GPO 都有用户配置和计算机配置部分。用户配置策略仅适用于用户。

![group policy user configuration](https://activedirectorypro.com/wp-content/uploads/2022/09/gpo-user-configuration.webp "gpo-user-configuration")

**Computer Configuration Policies** = The GPO computer configuration policies apply to the computer, not the user.  
**计算机配置策略** = GPO 计算机配置策略适用于计算机，而不是用户。

![group policy computer configuration](https://activedirectorypro.com/wp-content/uploads/2022/09/gpo-computer-configuration.webp "gpo-computer-configuration") 

# Create Active Directory Test Environment 
[Create Active Directory Test Environment (Complete Guide) - Active Directory Pro](https://activedirectorypro.com/create-active-directory-test-environment/) 

# backup and restore AD
[Backup Active Directory (Full and Incremental Backup) - Active Directory Pro](https://activedirectorypro.com/backup-active-directory/)
[How to Restore Active Directory (Full Restore & System State) - Active Directory Pro](https://activedirectorypro.com/restore-active-directory-from-backup/) 

# unlock user account
![](../img/windows_lab-20250522-1.png)
![](../img/windows_lab-20250522-2.png)

# folder sharing
create the shares folder  
![](../img/windows_lab-20250522-3.png)
change the shares folder security remove inheritance and remove user   
![](../img/windows_lab-20250522-4.png)
validate the result  
![](../img/windows_lab-20250522-5.png)  
map the network drive for quick access  
![](../img/windows_lab-20250522-6.png)  
![](../img/windows_lab-20250522-7.png)  
![](../img/windows_lab-20250522-8.png)

# remote desktop
![](../img/windows_lab-20250523.png)
![](../img/windows_lab-20250523-1.png)
![](../img/windows_lab-20250523-2.png)

another way [Solve PC problems remotely with Remote Assistance - Microsoft Support](https://support.microsoft.com/en-au/windows/solve-pc-problems-remotely-with-remote-assistance-cf384ff4-6269-d86e-bcfe-92d72ed55922)  
![](../img/windows_lab-20250524.png)
![](../img/windows_lab-20250524-1.png)

# Group Policy
![](../img/windows_lab-20250524-2.png)
![](../img/windows_lab-20250524-6.png)
![](../img/windows_lab-20250524-7.png)
![](../img/windows_lab-20250525-1.png)

# fix an “RPC server is unavailable” error
[How to fix an “RPC server is unavailable” error | Proton VPN](https://protonvpn.com/support/rpc-server-unavailable?srsltid=AfmBOorB--gUX6T3YA73M7TMSfwb6V7U5rCvN9-cZYM01H1g75p3sTzP) 
```
Ensure all RPC services are running on your PC
1. Search for the Services app and Open it. 

Open the Services app
2. Find DCOM Server Process Launcher and double-click on it.

Find the DCOM Server Process Launcher and double-click on it.
3. Ensure that:

Startup type is set to Automatic
Service status is Running.
If they aren’t, set Startup type to Automatic and Start the service. 

Set Startup type to Automatic and Start the service
4. Repeat steps 2 and 3 for the following services:

Remote Procedure Call (RPC)
RPC Endpoint Mapper
Remote Procedure Call (RPC) Locator
5. Restart your PC and see if the problem is resolved. 
```

# generate group policy result
![](../img/windows_lab-20250525-2.png)

# use PDQ deploy to install software
[PDQ: Software Deployment & Inventory Management done right](https://www.pdq.com/)  
![](../img/windows_lab-20250526.png)
[Installing PDQ Deploy and Your First Deployment - YouTube](https://www.youtube.com/watch?v=i1vi0--iHT0)  
![](../img/windows_lab-20250526-1.png)
![](../img/windows_lab-20250526-2.png)
![](../img/windows_lab-20250526-3.png)

# PDQ Inventory 
[Software inventory management made easy with PDQ Inventory | PDQ](https://www.pdq.com/landing/pdq-inventory/?utm_feeditemid=&utm_device=c&utm_term=pdq%20inventory&utm_source=google&utm_medium=cpc&utm_campaign=di_google_brand_gl_pdq_inventory&hsa_cam=17520126671&hsa_grp=139548835164&hsa_mt=e&hsa_src=g&hsa_ad=704097747765&hsa_acc=2336542827&hsa_net=adwords&hsa_kw=pdq%20inventory&hsa_tgt=kwd-1256811518286&hsa_ver=3&campaign_id=701TU00000DdWOm&gad_source=1&gad_campaignid=17520126671&gbraid=0AAAAAC9qJYld2rI1DSu547CrU19BtmaoO&gclid=Cj0KCQjw_8rBBhCFARIsAJrc9yDa8pfbdI-UWH3ZiWucwG1x_LwSlIIIljNfY1VFeRBQY-pJxWtLPwEaAlCqEALw_wcB) 
![](../img/windows_lab-20250526-4.png)
![](../img/windows_lab-20250526-5.png)
![](../img/windows_lab-20250526-6.png)
