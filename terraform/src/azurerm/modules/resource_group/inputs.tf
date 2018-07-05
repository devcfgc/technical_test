variable "name" {
  description = "Defines the name of the Resource Group within Azure"
}

variable "location" {
  description = "Defines the Azure Data Center in which the Resource Group exists"
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
