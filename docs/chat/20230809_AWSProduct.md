SaaS provides ready-to-use applications, PaaS abstracts the underlying infrastructure to streamline application deployment, and IaaS provides virtualized infrastructure resources for greater control and flexibility. SaaS 提供即用型应用程序，PaaS 抽象化底层基础架构以简化应用程序部署，IaaS 提供虚拟化基础架构资源以实现更好的控制和灵活性。 

# Saas
Software-as-a-Service (SaaS) is a cloud computing model where software applications are delivered over the internet as a service. This approach eliminates the need for you to install, manage, and maintain the software locally on your own infrastructure. AWS offers a variety of SaaS products and services that are fully managed and can be easily integrated into your existing infrastructure.
软件即服务 （SaaS） 是一种云计算模型，其中软件应用程序通过互联网即服务交付。这种方法消除了您在自己的基础结构上本地安装、管理和维护软件的需要。AWS 提供各种完全托管的 SaaS 产品和服务，可以轻松集成到您现有的基础设施中。
1. Amazon S3 (Simple Storage Service):  
    Amazon S3（简单存储服务）：  
    Amazon S3 provides scalable object storage for storing and retrieving data. It is highly durable, secure, and offers various storage classes catered to different use cases. You can find more information and documentation about Amazon S3 here:  
    Amazon S3 提供可扩展的对象存储，用于存储和检索数据。它非常耐用、安全，并提供各种存储类以满足不同的用例。您可以在此处找到有关 Amazon S3 的更多信息和文档：
    
    - Documentation: [https://aws.amazon.com/documentation/s3/](https://aws.amazon.com/documentation/s3/)


2. Amazon RDS (Relational Database Service):  
    Amazon RDS（关系数据库服务）：  
    Amazon RDS is a managed database service that supports popular database engines such as MySQL, PostgreSQL, Oracle, and more. It simplifies the provisioning, scaling, and high availability of databases. Learn more about Amazon RDS and its documentation here:  
    Amazon RDS 是一种托管数据库服务，支持流行的数据库引擎，如 MySQL、PostgreSQL、Oracle 等。它简化了数据库的预配、扩展和高可用性。在此处了解有关 Amazon RDS 及其文档的更多信息：
    
    - Documentation: [https://aws.amazon.com/documentation/rds/](https://aws.amazon.com/documentation/rds/)


3. Amazon WorkSpaces: 亚马逊工作区：  
    Amazon WorkSpaces is a fully managed desktop-as-a-service (DaaS) offering, delivering virtual desktops to users anywhere, anytime. It provides a secure, scalable, and customizable desktop computing experience in the cloud. Explore Amazon WorkSpaces documentation for more details:  
    Amazon WorkSpaces 是一种完全托管的桌面即服务 （DaaS） 产品，可随时随地向用户交付虚拟桌面。它在云中提供安全、可扩展且可自定义的桌面计算体验。浏览 Amazon WorkSpaces 文档，了解更多详细信息：
    
    - Documentation: [https://aws.amazon.com/documentation/workspaces/](https://aws.amazon.com/documentation/workspaces/)

# Paas
Platform-as-a-Service (PaaS) is a cloud computing model that provides a platform for developing, deploying, and managing applications without the need to worry about the underlying infrastructure. AWS offers various PaaS services that abstract away the complexities of infrastructure management, allowing you to focus on application development and deployment.
平台即服务 （PaaS） 是一种云计算模型，它提供了一个用于开发、部署和管理应用程序的平台，而无需担心底层基础结构。AWS 提供各种 PaaS 服务，这些服务消除了基础设施管理的复杂性，使您能够专注于应用程序开发和部署。
1. AWS Elastic Beanstalk: AWS Elastic Beanstalk：  
    AWS Elastic Beanstalk is a fully managed platform that makes it easy to deploy and scale applications. You simply upload your code, and Elastic Beanstalk handles the deployment, capacity provisioning, load balancing, and health monitoring of your application. Learn more about Elastic Beanstalk and its documentation here:  
    AWS Elastic Beanstalk 是一个完全托管的平台，可以轻松部署和扩展应用程序。您只需上传代码，Elastic Beanstalk 就会处理应用程序的部署、容量预置、负载均衡和运行状况监控。在此处了解有关 Elastic Beanstalk 及其文档的更多信息：
    
    - Documentation: [https://aws.amazon.com/documentation/elastic-beanstalk/](https://aws.amazon.com/documentation/elastic-beanstalk/)


2. AWS Lambda: AWS Lambda：  
    AWS Lambda is a serverless compute service that lets you run your code without provisioning or managing servers. It allows you to execute your code in response to events or via direct invocation, and scales automatically based on the incoming workload. Explore more about Lambda and its documentation here:  
    AWS Lambda 是一种无服务器计算服务，可让您在不预置或管理服务器的情况下运行代码。它允许您执行代码以响应事件或通过直接调用，并根据传入的工作负载自动缩放。在此处探索有关 Lambda 及其文档的更多信息：
    
    - Documentation: [https://aws.amazon.com/documentation/lambda/](https://aws.amazon.com/documentation/lambda/)

3. AWS API Gateway: AWS API Gateway：  
    AWS API Gateway is a fully managed service that makes it easy to create, publish, and manage APIs at any scale. It provides features like authentication, caching, and request throttling, making it convenient to build robust and scalable APIs. Learn more about AWS API Gateway and its documentation here:  
    AWS API Gateway 是一项完全托管的服务，可让您轻松创建、发布和管理任何规模的 API。它提供身份验证、缓存和请求限制等功能，便于构建可靠且可扩展的 API。在此处了解有关 AWS API 网关及其文档的更多信息：
    
    - Documentation: [https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html](https://docs.aws.amazon.com/apigateway/latest/developerguide/welcome.html)


# Iaas
Infrastructure-as-a-Service (IaaS) is a cloud computing model that provides virtualized computing resources over the internet. With IaaS, you can provision and manage virtualized infrastructure components such as virtual machines, storage, networks, and security. AWS offers a comprehensive set of IaaS products that allow you to build, secure, and scale your infrastructure efficiently.  
基础架构即服务 （IaaS） 是一种云计算模型，可通过互联网提供虚拟化计算资源。借助 IaaS，您可以配置和管理虚拟化基础架构组件，例如虚拟机、存储、网络和安全性。AWS 提供了一套全面的 IaaS 产品，使您能够高效地构建、保护和扩展基础设施。
1. Amazon EC2 (Elastic Compute Cloud):  
    Amazon EC2（Elastic Compute Cloud）：  
    Amazon EC2 provides resizable compute capacity in the cloud. It allows you to provision virtual servers (instances) on-demand with various configurations, scale up or down as needed, and have full administrative access to the underlying operating system. Learn more about EC2 and its documentation here:  
    Amazon EC2 在云中提供可调整大小的计算容量。它允许您使用各种配置按需配置虚拟服务器（实例），根据需要进行扩展或缩减，并具有对底层操作系统的完全管理访问权限。在此处了解有关 EC2 及其文档的更多信息：
    
    - Documentation: [https://aws.amazon.com/documentation/ec2/](https://aws.amazon.com/documentation/ec2/)
2. Amazon S3 (Simple Storage Service):  
    Amazon S3（简单存储服务）：  
    Amazon S3 is a scalable object storage service designed to store and retrieve large amounts of unstructured data. It provides durability, availability, and security for your data. With S3, you can store and retrieve any amount of data from anywhere on the web. Explore Amazon S3 documentation for more details:  
    Amazon S3 是一种可扩展的对象存储服务，旨在存储和检索大量非结构化数据。它为您的数据提供持久性、可用性和安全性。使用 S3，您可以从 Web 上的任何位置存储和检索任意数量的数据。浏览 Amazon S3 文档，了解更多详细信息：
    
    - Documentation: [https://aws.amazon.com/documentation/s3/](https://aws.amazon.com/documentation/s3/)
3. Amazon VPC (Virtual Private Cloud):  
    Amazon VPC（虚拟私有云）：  
    Amazon VPC allows you to create a private and isolated virtual network in the AWS cloud. It gives you control over networking resources, including IP address ranges, subnets, route tables, and security groups. Understand more about VPC and its capabilities through the documentation:  
    Amazon VPC 允许您在 AWS 云中创建私有和隔离的虚拟网络。它使您可以控制网络资源，包括 IP 地址范围、子网、路由表和安全组。通过文档了解有关 VPC 及其功能的更多信息：
    
    - Documentation: [https://aws.amazon.com/documentation/vpc/](https://aws.amazon.com/documentation/vpc/)
4. AWS Auto Scaling: AWS Auto Scaling：  
    AWS Auto Scaling enables you to automatically adjust your resource capacity based on demand. It provides unified scaling across multiple services like EC2 instances, DynamoDB tables, and more. You can define scaling policies and let AWS Auto Scaling handle the scaling for you. Learn more about AWS Auto Scaling here:  
    AWS Auto Scaling 使您能够根据需求自动调整资源容量。它提供跨多个服务（如 EC2 实例、DynamoDB 表等）的统一扩展。您可以定义扩展策略，让 AWS Auto Scaling 为您处理扩展。在此处了解有关 AWS Auto Scaling 的更多信息：
    
    - Documentation: [https://aws.amazon.com/documentation/autoscaling/](https://aws.amazon.com/documentation/autoscaling/)