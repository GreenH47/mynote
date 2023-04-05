# Assignment 1
[git repository for FIT5225_23s1/assignment1/](https://github.com/GreenH47/FIT5225_23s1/tree/main/assignment1)  
## requirement
+ Writing a python web service that accepts images in JSON object format, uses YOLO and OpenCV  to process images, and returns a JSON object with a list of detected objects.  
+ Building a Docker Image for the object detection web service.  
+ Creating a Kubernetes cluster on virtual machines (instances) in the Oracle Cloud Infrastructure  (OCI).  
+ Deploying a Kubernetes service to distribute inbound requests among pods that are running the object detection service.  
+ Testing the system under varying load and number of pods conditions
## web service  
develop a RESTful API that allows clients to upload images to the server  

You must use Flask to build your web service and any port over 1024. Your Flask server should be multi-threaded to handle multiple clients concurrently.  

Each image should be sent to the web service using an HTTP POST request containing 
JSON object with a unique ID (e.g. UUID) 
and a base64-encoded image (the client script for sending images to the web service is provided to you) 
convert the image into a textual representation using the base64 method A sample JSON request use<font color="#548dd4">d to sen</font>d an image could be as follows 
```json
{  
	"id":"06e8b9e0-8d2e-11eb-8dcd-0242ac130003",  
	"image":"YWRzZmFzZGZhc2RmYXNkZmFzZGYzNDM1MyA7aztqMjUzJyBqaDJsM2 ..."  
}
```
The web service creates a thread per request and uses YOLO and OpenCV python libraries to detect objects in the image.  
You can leverage this script and build a web service using flask and also handle base64 decoding. For each image (request), your web service returns a JSON object with a list of all objects detected in that image as follows  
```json
{  
	"id":"The id from the client request",  
	"objects": [  
		{  
		"label": "human/book/cat/...",  
		"accuracy": a real number between 0-1,  
		"rectangle": {  
			"height": number,  
			"left": number,  
			"top": number,  
			"width": number  
			}  
		}  
		...  
	]  
}
```
The “id” is the same id sent by the client along with the image. This is used to associate an asynchronous  response with the request at the client-side. The “label” represents the type of object detected, e.g., cat,  book, etc. “Accuracy” is a value representing the precision in object detection and a rectangle is a JSON  object showing the position of a box around the object in the image. A sample response is shown below:  
```json
{  
"id": "2b7082f5-d31a-54b7-a46e-5e4889bf69bd",  
"objects": [  
		{  
			"label": "book",  
			"accuracy": 0.7890481352806091,  
			"rectangle": {"height": 114, "left": 380, "top": 363, "width": 254}  
		},  
		{  
			"label": "cat",  
			"accuracy": 0.6877481352806091,  
			"rectangle": {"height": 114, "left": 180, "top": 63, "width": 254}  
		}  
	]  
}
```

You only need to build the server-side RESTful API. We provided the client script (`Cloudiod_client.py`  file) that is designed to invoke the REST API with a different number of requests. Please make sure your  web service is fully compatible with requests sent by the given client script  
use the yolov3-tiny framework to develop a fast and reliable RESTful API for  object detection  We have provided the yolov3-tiny config file and weights in the `yolo_tiny_configs.zip` file. We have  also provided you with a sample group of images (128 images in `inputfolder` in the `client.zip` file and you should use them for testing2. Please extract the given `client.zip` file, where you can find `inputfolder` and `Cloudiod_client.py` along with a `readme` file that explains how you to use them. You can run the client application as follows 
```
python Cloudiod_client.py <inputfolder> <endpoint> <num_threads>

inputfolder represents the folder that contains 128 images for the test. 
The endpoint is the REST  API URL of your web service  
num_threads indicates the total number of threads sending requests  to the server concurrently.  
Please refer to the client script Cloudiod_client.py and ReadMe.txt file for  more details.  
python Cloudiod_client.py inputfolder/ http://118.138.43.2:5000/api/object_detection 16
```

## Dockerfile - 10 Marks
You are required to build a Dockerfile that includes all the required instructions to build your Docker image. [Dockerfile reference](https://docs.docker.com/engine/reference/builder/)  To reduce complexity, dependencies, file sizes, and build times, avoid installing extra or unnecessary package Optimisation of your Dockerfile while keeping it easy to read and maintain is important  

## Kubernetes Cluster - 20 Marks
You are tasked to install and configure a Kubernetes cluster on OCI VMs. 
For this purpose, you are  going to install K8s on group of three VM instances on OCI (All your VM inastances should be AMD  machines, shape VM.Standard.E4.Flex, 8GB Memory and 4 OCPUs).   
You need to setup a K8s cluster with 1 controller and 2 worker nodes that run on OCI VMs. You need to install Docker on VMs. You  should configure your K8s to use Docker to set up and initialise a Kubernetes cluster for you
## Kubernetes Service - 20 Marks
you need to create service and deployment configurations that will in turn create and deploy required pods in the cluster. [Kubernetes Documentation | Kubernetes](https://kubernetes.io/docs/home/)  
Please make sure you set CPU request and CPU limit to “0.5” and memory request and limit to “512MiB” for each pod. initially, you will start with a single pod to test your web service and gradually increase the number as described in the Section. the preferred way of achieving this is by creating replica sets and scaling them accordingly  
you are required to expose your deployment to enable communication with the web service  running inside your pods. You can make use of the NodePort capabilities of Kubernetes to expose your  deployment. 
you should ensure that your controller instance has all the necessary ports open and that necessary network configurations, including OCI “Security Lists,” are properly set up. You may also need to open ports using  “firewalld” on instances. It is recommended that you map a well-known port (such as 80 or 8080) to your  Kubernetes service port
## Experiments 
test your system under a varying number of threads in the client with a different number of resources (pods) in your cluster When the system is up and running, you will run experiments to test the impact of num of threads in the client and number of pods (available resources) in the cluster on the response time of the service The `Cloudiod_client.py` script automatically measures the average response time for you and prints it at the end of its execution 
The number of pods must be scaled to 1, 2, 4, 8 and 16. Since the amount of CPU and Memory allocated to each pod are limited. You will also vary  the number of threads in the client to analyse the impact of increasing the load on the overall average response time of the service To do so, you vary the `num_threads` argument of `Cloudiod_client.py` script  to 1, 2, 4, 8, and 16. This way you will run a total of 5 × 5 = 25 experiments. For each run, 128 images  will be sent to the server and the average response time is collected.  
you are required to conduct two sets of experiments where the client is executed locally on the master node of kubernetes and on a VM instance in your pt-project in Nectar.  
your goal is to create two separate 2D line plots based on the client location (local or Nectar VM) and the number of pods (1, 2, 4, 8, and 16) as the legend. The x-axis should represent the number of threads (1, 2, 4, 8, and 16), and the y-axis should represent the average response time in seconds. . Make sure to run each experiment multiple times to ensure that the average response time values are consistent. If you repeat an experiment,  add a new column to the Excel sheet to record the results  
In your report, discuss this plot and justify  your observations. Please make sure you are using the correct labels for the plot. To automate your  experimentation and collect data points, you can write a script that automatically varies the parameters for the experiments and collects data points
