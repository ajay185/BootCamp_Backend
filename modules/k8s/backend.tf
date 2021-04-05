provider "kubernetes" {
    #load_config_file = "false"
    host = var.host
    client_certificate = var.client_certificate
    client_key = var.client_key
    cluster_ca_certificate = var.cluster_ca_certificate
}

resource "kubernetes_namespace" "n" {
  metadata {
    name = "kubernetes-aks1"
  }
}

resource "kubernetes_deployment" "backend-deployment" {
  metadata {
    name = "cloud-ninja-backend"
    labels = {
      App = "backend"
    }
    namespace = kubernetes_namespace.n.metadata[0].name
  }

  spec {
    replicas                  = 3
    progress_deadline_seconds = 60
    selector {
      match_labels = {
        App = "cloud-ninja-backend"
      }
    }
    template {
      metadata {
        labels = {
          App = "cloud-ninja-backend"
        }
      }
      spec {
        container {
          image = "ajay185/backend:tagversion"
          name  = "cloud-ninja-backend"

          port {
            container_port = 8080
          }

          resources {
            limits = {
              cpu    = "0.2"
              memory = "2562Mi"
            }
            requests = {
              cpu    = "0.1"
              memory = "50Mi"
            }
          }
        }
      }
    }
  }
}
