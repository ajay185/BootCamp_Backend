pwd
cd modules/k8s
sed "s/tagversion/$1/g" backend.tf > backend1.tf
rm backend.tf
