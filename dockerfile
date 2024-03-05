# Use a lightweight base image
FROM arm64v8/python:3.8-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the local MkDocs files into the container
COPY . /app

# Install MkDocs and any required plugins
RUN pip install mkdocs mkdocs-material

# Build the MkDocs site
RUN mkdocs build

# Expose port 8000 to serve the MkDocs site
EXPOSE 8000

# Command to serve the MkDocs site using the built-in HTTP server
CMD ["mkdocs", "serve", "-a", "0.0.0.0:8000"]
