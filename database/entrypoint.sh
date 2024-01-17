#!/bin/bash
set -e

# Run SQL Server
/opt/mssql/bin/sqlservr &

# Wait for SQL Server to start
sleep 20s

# Run SQL scripts
# /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -d master -i /docker-entrypoint-initdb.d/01_create_database.sql
# /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -d master -i /docker-entrypoint-initdb.d/01scriptdbcalidad.sql
# /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -d dbcalidad -i /docker-entrypoint-initdb.d/02TurnosScript.sql
# /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -d dbcalidad -i /docker-entrypoint-initdb.d/03MaquinasScript.sql

# Keep the container running
tail -f /dev/null
