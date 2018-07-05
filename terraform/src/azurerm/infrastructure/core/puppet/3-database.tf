module "database" {
  source                = "../../../modules/machines/ubuntu/vm-internal-no-data-disk"
  name                  = "${var.company}-${var.data_center}-puppet3-db-01"
  size                  = "${var.database_size}"
  location              = "${var.location}"
  resource_group_name   = "${module.resource_group.name}"
  storage_account_name  = "${var.company}${var.data_center}puppetsa3"
  storage_account_type  = "Standard_LRS"
  subnet_id             = "${var.database_subnet_id}"
  data_center           = "${var.data_center}"
  availability_set_name = "${var.company}-${var.data_center}-puppet3-db"

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
