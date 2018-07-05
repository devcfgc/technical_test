# Core
variable "virtual_machine_name" {
  description = "The Name of the Virtual Machine, used as a Prefix for the NIC"
}

variable "resource_group_name" {
  description = "Defines the name of the Resource Group within Azure"
}

variable "location" {
  description = "Defines the Azure Data Center in which the Resource Group exists"
}

# Networking
variable "subnet_id" {
  description = "The Subnet ID where the NIC should be created"
}

variable "backend_address_pool_ids" {
  default     = []
  description = "An Array of Backend Address Pool ID's to associate with the NIC"
  type        = "list"
}

# Storage
variable "storage_account_name" {
  description = "Defines the name of the storage account to be created."
}

variable "storage_account_type" {
  default = "Standard_LRS"
}

# Tags
variable "cost_center" {
  description = "The Cost Center to associate this Virtual Machine with"
}

variable "product" {
  description = "The Product this Virtual Machine is used for, for Cost purposes"
}

variable "team" {
  description = "The Team who owns this Virtual Machine, for Cost purposes"
}
