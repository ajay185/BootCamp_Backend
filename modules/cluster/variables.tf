variable "resourcename" {
  default = "k8s-resources"
}

variable "clustername" {
  default = "kubernetes-aks1"
}

variable "location" {
  default = "East US"
}

variable "size" {
  default = "Standard_D2_v3"
}

variable "dnspreffix" {
  default = "kubecluster"
}

variable "agentnode" {
  default = "1"
}

variable "sp_client_id" {
}

variable "sp_client_secret" {
}