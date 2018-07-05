module "core" {
  source = "./core"

  company     = "${var.company}"
  data_center = "${var.data_center}"
  location    = "${var.location}"

  backend_subnet_id  = "${var.backend_subnet_id}"
  database_subnet_id = "${var.database_subnet_id}"
  frontend_subnet_id = "${var.frontend_subnet_id}"

  admin_username     = "${var.admin_username}"
  admin_password     = "${var.admin_password}"
  domain_name        = "${var.domain_name}"
  directory_username = "${var.directory_username}"
  directory_password = "${var.directory_password}"
  puppet_host        = "${var.puppet_host}"
  puppet_environment = "${var.puppet_environment}"
}

module "products" {
  source = "./products"

  location = "${var.location}"
}
