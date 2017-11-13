sudo docker build -t lyndemberg/banco ./postgres
sudo docker build -t lyndemberg/app .
sudo docker run -p 5433:5432 -d --name banco -v $(pwd)/data:/var/lib/postgresql/data lyndemberg/banco
sudo docker run -p 8081:8080 -d --name app --link banco:host-banco lyndemberg/app
