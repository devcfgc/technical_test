variable "resource_group_name" {
  description = "Defines the name of the Resource Group within Azure"
}

variable "data_center" {
  description = "Defines the Data Center name (e.g. E1/U2/A1)"
}

variable "location" {
  description = "Defines the Azure Data Center in which the Resource Group exists"
}

# Domain Joining
variable "virtual_machine_name" {
  description = "The Name of the Virtual Machine this extension should be run on"
}

variable "domain_name" {
  description = "The Domain Name to associated with the machine - e.g. `ci.com` / `production.dom`"
}

# Puppet
variable "puppet_host" {
  description = "The FQDN of the Puppet Server"
}

variable "puppet_environment" {
  description = "The Puppet Environment - Valid values are either `ci`, `preprod` or `production`."
}
