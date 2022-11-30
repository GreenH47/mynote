Create time: 2022-10-29  
Last update: {{ git_revision_date }}
# site_building
This blog is build on Markdown file written by GreenH47 and transferred to html page by [Mkdocs](https://www.mkdocs.org/) and [Material](https://squidfunk.github.io/mkdocs-material/)   
The information about how to build this website can be found in [How to build this site](about_site_building.md)  
This website is hosting on [Gitpages](https://pages.github.com/)  

https://teddywarner.org/Projects/ProjectPortfolioSite/#

https://stackoverflow.com/questions/63438788/how-to-add-a-landing-page-to-a-mkdocs-doc-site-using-mkdocs-material

https://github.com/squidfunk/mkdocs-material/issues/1996

## Project folder layout

```
mkdocs.yml    # The configuration file.
.github/      # github auto deployment of your project (not include in the source file)  
site/         # build up webpage from md files
docs/
	index.md  # The homepage.
	xxx.md    # Other markdown pages
	img/      # images and other attachment.
```
## Commands

* `mkdocs new [dir-name]` - Create a new project.
* `mkdocs serve` - Start the live-reloading docs server.
* `mkdocs build` - Build the documentation site.
* `mkdocs -h` - Print help message and exit.
