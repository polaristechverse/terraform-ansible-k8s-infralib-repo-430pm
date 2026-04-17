def call() {
    sh """
        terraform init
        terraform fmt
        terraform validate
        terraform plan
    """
}