variable "name" {
  description = "Defines the Prefix for the Load Balancer"
}

# Resource Group
variable "resource_group_name" {
  description = "Defines the name of the Resource Group within Azure"
}

variable "location" {
  description = "Defines the Azure Data Center in which the Resource Group exists"
}

# Load Balancer
variable "port" {
  default     = 443
  description = "Defines the Port used to check the Node is healthy"
}

variable "primary_frontend_configuration_name" {
  default     = "public"
  description = "Defines the name of the Primary Front End Configuration associated wih this Load Balancer"
}

# Tags
variable "cost_center" {
  description = "The Cost Center to associate this Resource Group with"
}

variable "product" {
  description = "The Product this Resource Group is used for, for Cost purposes"
}

variable "team" {
  description = "The Team who owns this Resource Group, for Cost purposes"
}
