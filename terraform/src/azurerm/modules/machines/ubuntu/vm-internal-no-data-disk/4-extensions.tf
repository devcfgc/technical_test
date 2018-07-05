module "extensions" {
  source = "../extensions"

  location             = "${var.location}"
  resource_group_name  = "${module.base.resource_group_name}"
  virtual_machine_name = "${azurerm_virtual_machine.machine.name}"

  domain_name        = "${var.domain_name}"
  puppet_host        = "${var.puppet_host}"
  puppet_environment = "${var.puppet_environment}"
  data_center        = "${var.data_center}"
}
