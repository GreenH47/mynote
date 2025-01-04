[Getting started | Kubernetes](https://kubernetes.io/docs/setup/)  
[Introduction to Kubernetes (LFS158) - The Linux Foundation](https://trainingportal.linuxfoundation.org/courses/introduction-to-kubernetes)  

# exam scope
 **A Certified Kubernetes Administrator (CKA) will be able to:   
认证 Kubernetes 管理员 (CKA) 将能够：**

- Demonstrate their ability to do basic installation as well as configuring and managing production-grade Kubernetes clusters.  
    展示他们进行基本安装以及配置和管理生产级 Kubernetes 集群的能力。
- Understand key concepts such as Kubernetes networking, storage, security, maintenance, logging and monitoring, application lifecycle, troubleshooting, API object primitives.  
    了解 Kubernetes 网络、存储、安全性、维护、日志记录和监控、应用程序生命周期、故障排除、API 对象原语等关键概念。
- Ability to establish basic use-cases for end users.  
    能够为最终用户建立基本用例。

## Storage – 10%  存储 – 10%**

- Implement storage classes and dynamic volume provisioning  
    实施存储类别和动态卷配置
- Configure volume types, access modes and reclaim policies  
    配置卷类型、访问模式和回收策略
- Manage persistent volumes and persistent volume claims  
    管理持久卷和持久卷声明

## Troubleshooting – 30%  故障排除 – 30%**

- Troubleshoot clusters and nodes  
    集群和节点故障排除
- Troubleshoot cluster components  
    对集群组件进行故障排除
- Monitor cluster and application resource usage  
    监控集群和应用程序资源使用情况
- Manage and evaluate container output streams  
    管理和评估容器输出流
- Troubleshoot services and networking  
    排除服务和网络故障

## Workloads and Scheduling – 15%   
工作负载和调度 – 15%**

- Understand application deployments and how to perform rolling update and rollbacks  
    了解应用程序部署以及如何执行滚动更新和回滚
- Use ConfigMaps and Secrets to configure applications  
    使用 ConfigMap 和 Secrets 来配置应用程序
- Configure workload autoscaling  
    配置工作负载自动缩放
- Understand the primitives used to create robust, self-healing, application deployments  
    了解用于创建健壮的、自我修复的应用程序部署的原语
- Configure Pod admission and scheduling (limits, node affinity, etc.)  
    配置 Pod 准入和调度（限制、节点关联性等）

## Cluster Architecture, Installation and Configuration – 25%  
集群架构、安装和配置 – 25%**

- Manage role based access control (RBAC)  
    管理基于角色的访问控制 (RBAC)
- Prepare underlying infrastructure for installing a Kubernetes cluster  
    准备用于安装 Kubernetes 集群的底层基础设施
- Create and manage Kubernetes clusters using kubeadm  
    使用 kubeadm 创建和管理 Kubernetes 集群
- Manage the lifecycle of Kubernetes clusters  
    管理 Kubernetes 集群的生命周期
- Implement and configure a highly-available control plane  
    实施和配置高可用性控制平面
- Use Helm and Kustomize to install cluster components  
    使用 Helm 和 Kustomize 安装集群组件
- Understand extension interfaces (CNI, CSI, CRI, etc.)  
    了解扩展接口（CNI、CSI、CRI 等）
- Understand CRDs, install and configure operators  
    了解 CRD、安装和配置操作员

## Servicing and Networking – 20%  
服务和网络 – 20%**

- Understand connectivity between Pods  
    了解 Pod 之间的连接
- Define and enforce Network Policies  
    定义和实施网络策略
- Use ClusterIP, NodePort, LoadBalancer service types and endpoints  
    使用 ClusterIP、NodePort、LoadBalancer 服务类型和端点
- Use the Gateway API to manage Ingress traffic  
    使用网关 API 管理入口流量
- Know how to use Ingress controllers and Ingress resources  
    了解如何使用 Ingress 控制器和 Ingress 资源
- Understand and use CoreDNS  
    了解并使用 CoreDNS

# Basic concept
## Container Orchestration容器编排
To enable these functionalities you need an underlying platform with a set of resources. The platform needs to orchestrate the connectivity between the containers and automatically scale up or down based on the load. This whole process of automatically deploying and managing containers is known as Container Orchestration. 要启用这些功能，您需要一个具有一组资源的底层平台。该平台需要编排容器之间的连接，并根据负载自动扩展或缩小。自动部署和管理容器的整个过程称为容器编排。  
There are various advantages of container orchestration. Your application is now highly available as hardware failures do not bring your application down because you have multiple instances of your application running on different nodes. The user traffic is load balanced across the various containers. When demand increases, deploy more instances of the application seamlessly and within a matter of second and we have the ability to do that at a service level. When we run out of hardware resources, scale the number of nodes up/down without having to take down the application. And do all of these easily with a set of declarative object configuration file容器编排有多种优点。您的应用程序现在具有高可用性，因为硬件故障不会导致您的应用程序停机，因为您的应用程序的多个实例在不同的节点上运行。用户流量在各个容器之间进行负载平衡。当需求增加时，只需几秒钟即可无缝部署更多应用程序实例，我们有能力在服务级别上做到这一点。当我们用完硬件资源时，可以增加/减少节点数量，而无需关闭应用程序。并使用一组声明性对象配置文件轻松完成所有这些  
## Nodes(Minions)  
A node is a machine – physical or virtual – on which kubernetes is installed. A node is a worker machine and this is were containers will be launched by kubernetes. 节点是安装了 kubernetes 的物理或虚拟机器。节点是一台工作机器，这是 kubernetes 启动的容器。
## Cluster 
A cluster is a set of nodes grouped together. This way even if one node fails you have your application still accessible from the other nodes. Moreover having multiple nodes helps in sharing load as well 集群是一组聚集在一起的节点。这样，即使一个节点发生故障，您仍然可以从其他节点访问您的应用程序。此外，拥有多个节点也有助于分担负载  
