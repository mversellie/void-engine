# VOID ENGINE

## Summary
Void-engine is a simple search engine which reads data from a Solr datastore.  It uses a Spring Backend to serve a REST API as well as the static assets for the site. The frontend is coded using the Vue-JS Framework. 

Nutch was used as both a spider and an indexer to crawl the web and save contents of web pages to a Solr repository.  Starting location for the crawl was [DZone.com](https://dzone.com)

## Dependencies
If you wish to fork this, to run this you will need 
- Data from a Nutch crawl(the defaults for 2.3 were used while crawling).  
- A Solr instance running 8.x loaded with your Nutch data.  You should also configure it with basic security.
- JDK 11+

## Links:
- Preview/Deployment - [www.voidengine.io](https://www.voidengine.io) *last crawled 2018 so expect outdated links.*
