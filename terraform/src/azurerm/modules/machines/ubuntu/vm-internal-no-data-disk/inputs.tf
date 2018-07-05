# Core
variable "name" {
  description = "The name assigned to the virtual machine in Azure"
}

variable "size" {
  default     = "Standard_A0"
  description = "The size of the machine to create in Azure"
}

variable "resource_group_name" {
  description = "Defines the name of the Resource Group within Azure"
}

variable "availability_set_name" {
  description = "Defines the name of the Availaility Set"
}

variable "data_center" {
  description = "Defines the Ve Data Center name (e.g. E1/U2/A1)"
}

variable "location" {
  description = "Defines the Azure Data Center in which the Resource Group exists"
}

# Storage
variable "storage_account_name" {
  description = "Defines the name of the storage account to be created."
}

variable "storage_account_type" {
  default     = "Standard_LRS"
  description = "Defines the type of storage account to be created. Valid options are `Standard_LRS`, `Standard_ZRS`, `Standard_GRS`, `Standard_RAGRS`, `Premium_LRS`."
}

# Credentials
variable "admin_username" {
  description = "The Local Administrator username, used for Provisioning. This is disabled by Puppet."
}

variable "admin_password" {
  description = "The Local Administrator password, used for Provisioning. This is disabled by Puppet."
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

# Extensions
variable "domain_name" {
  description = "The Domain Name to associated with the machine - e.g. `ci.com` / `pp.com` / `production.dom`"
}

variable "puppet_host" {
  description = "The FQDN of the Puppet Server"
}

variable "puppet_environment" {
  description = "The Puppet Environment - Valid values are either `ci`, `preprod` or `production`."
}

# Tags
variable "auto_shutdown" {
  description = "The Auto Shutdown Schedule for this Virtual Machine e.g. `DoNotShutdown`"
}

variable "cost_center" {
  description = "The Cost Center to associate this Virtual Machine with"
}

variable "product" {
  description = "The Product this Virtual Machine is used for, for Cost purposes"
}

variable "team" {
  description = "The Team who owns this Virtual Machine, for Cost purposes"
}
