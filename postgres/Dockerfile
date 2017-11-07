FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD pgadmin
ENV POSTGRES_DB dac-cliente
COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/
