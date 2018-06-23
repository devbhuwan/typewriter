#!/usr/bin/env bash

#-----------------------
# Removed minikube
#-----------------------
#minikube stop; minikube delete
#docker stop $(docker ps -aq)
#rm -r ~/.kube ~/.minikube
#sudo rm /usr/local/bin/localkube /usr/local/bin/minikube
#systemctl stop '*kubelet*.mount'
#sudo rm -rf /etc/kubernetes/
#docker system prune -af --volumes
#------------------

curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 && chmod +x minikube
curl -Lo kubectl https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl && chmod +x kubectl

export MINIKUBE_WANTUPDATENOTIFICATION=false
export MINIKUBE_WANTREPORTERRORPROMPT=false
export MINIKUBE_HOME=$HOME
export CHANGE_MINIKUBE_NONE_USER=true
mkdir -p $HOME/.kube
touch $HOME/.kube/config

export KUBECONFIG=$HOME/.kube/config
sudo -E ./minikube start --vm-driver=none

# this for loop waits until kubectl can access the api server that Minikube has created
for i in {1..150}; do # timeout for 5 minutes
   ./kubectl get po &> /dev/null
   if [ $? -ne 1 ]; then
      break
  fi
  sleep 2
done