module "resource_group" {
  source      = "../../../modules/resource_group"
  name        = "${var.company}-${var.data_center}-puppet3"
  location    = "${var.location}"
  cost_center = "${var.cost_center}"
  product     = "${var.product}"
  team        = "${var.team}"
}
