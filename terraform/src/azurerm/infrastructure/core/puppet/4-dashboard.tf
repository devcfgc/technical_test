module "dashboard_load_balancer" {
  source              = "../../../modules/machines/common/load-balancer-public-tcp"
  name                = "${var.company}-${var.data_center}-puppet3-ui"
  location            = "${var.location}"
  resource_group_name = "${module.resource_group.name}"

  cost_center = "${var.cost_center}"
  product     = "${var.product}"
  team        = "${var.team}"
}

module "dashboard" {
  source                   = "../../../modules/machines/ubuntu/vm-internal-no-data-disk"
  name                     = "${var.company}-${var.data_center}-puppet3-ui-01"
  size                     = "${var.dashboard_size}"
  location                 = "${var.location}"
  resource_group_name      = "${module.resource_group.name}"
  storage_account_name     = "${var.company}${var.data_center}puppetsa3"
  storage_account_type     = "Standard_LRS"
  subnet_id                = "${var.frontend_subnet_id}"
  backend_address_pool_ids = ["${module.dashboard_load_balancer.backend_address_pool_id}"]
  data_center              = "${var.data_center}"
  availability_set_name    = "${var.company}-${var.data_center}-puppet3-ui"

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
