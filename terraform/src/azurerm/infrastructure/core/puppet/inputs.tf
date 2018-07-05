# Core
variable "company" {}

variable "data_center" {}

variable "location" {}

# Networking
variable "backend_subnet_id" {}

variable "database_subnet_id" {}

variable "frontend_subnet_id" {}

# Storage
variable "storage_account_type" {
  default = "Premium_LRS"
}

# Credentials
variable "admin_username" {}

variable "admin_password" {}

# Extensions
variable "domain_name" {}

variable "puppet_host" {}

variable "puppet_environment" {}

# Sizes
variable "server_size" {
  default = "Standard_F2s"
}

variable "database_size" {
  default = "Standard_F1"
}

variable "dashboard_size" {
  default = "Standard_F1"
}

# Tags
variable "auto_shutdown" {
  default = "DoNotShutdown"
}

variable "cost_center" {
  default = "Infrastructure"
}

variable "product" {
  default = "Puppet"
}

variable "team" {
  default = "ITOps"
}
