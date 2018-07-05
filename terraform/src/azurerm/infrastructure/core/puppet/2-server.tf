module "server" {
  source                = "../../../modules/machines/ubuntu/vm-internal-no-data-disk"
  name                  = "${var.company}-${var.data_center}-puppet3-sv-01"
  size                  = "${var.server_size}"
  location              = "${var.location}"
  resource_group_name   = "${module.resource_group.name}"
  storage_account_name  = "${var.company}${var.data_center}puppetsrvsa3"
  storage_account_type  = "${var.storage_account_type}"
  subnet_id             = "${var.backend_subnet_id}"
  data_center           = "${var.data_center}"
  availability_set_name = "${var.company}-${var.data_center}-puppet3-sv"

  admin_username     = "${var.admin_username}"
  admin_password     = "${var.admin_password}"
  domain_name        = "${var.domain_name}"
  puppet_host        = "${var.puppet_host}"
  puppet_environment = "${var.puppet_environment}"

  auto_shutdown = "${var.auto_shutdown}"
  cost_center   = "${var.cost_center}"
  product       = "${var.product}"
  team          = "${var.team}"
}
