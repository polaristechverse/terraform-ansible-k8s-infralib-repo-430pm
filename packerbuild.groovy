def call() {
    echo "Building ami with packer..."
    sh  'packer plugins install github.com/hashicorp/amazon'
    sh 'packer validate --var-file packer-vars.json packer.json'
    sh 'packer build --var-file packer-vars.json packer.json '
}
