# Börja med en basbuild som innehåller Node.js
FROM node:14-alpine

# Ange arbetskatalogen i behållaren till /app
WORKDIR /app

# Kopiera package.json och package-lock.json
COPY package*.json ./

# Installera projektets beroenden
RUN npm install

# Kopiera resten av appens källkod från din värden till buildens filsystem.
COPY . .

# Gör port 3000 tillgänglig för världen utanför denna behållare
EXPOSE 3000

# Bygg appen
RUN npm run build

# Använd "serve" för att servea "build"-mappen på port 3000
RUN npm install -g serve

# Kör appen
CMD ["serve", "-s", "build", "-l", "3000"]

