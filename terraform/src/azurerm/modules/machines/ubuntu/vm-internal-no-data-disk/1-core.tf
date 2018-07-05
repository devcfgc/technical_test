module "base" {
  source                   = "../../common/base-internal-vm"
  virtual_machine_name     = "${var.name}"
  location                 = "${var.location}"
  resource_group_name      = "${var.resource_group_name}"
  storage_account_name     = "${var.storage_account_name}"
  storage_account_type     = "${var.storage_account_type}"
  subnet_id                = "${var.subnet_id}"
  backend_address_pool_ids = "${var.backend_address_pool_ids}"

  cost_center = "${var.cost_center}"
  product     = "${var.product}"
  team        = "${var.team}"
}
