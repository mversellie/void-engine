# void-engine-backend
Backend Rest service for the void-Engine search engine.  This is a basic search engine that retrieves and identifies webpages with content corresponding to a given query.  It is not very well optimized, but was a good exploratory project for Solr and Nutch.

This service uses a Solr repository to retrieve data from a previous crawl from a Nutch crawler.  It then uses an Java Spring controller to forward that data to a user in JSON format.

Nutch is used as both a spider and an indexer to crawl the web and save contents of web pages to a Solr repository.  Starting location for the crawl was [DZone.com](https://dzone.com)


## Dependencies

To run this, you will need 
- Data from a Nutch crawl(the defaults for 2.3 were used while crawling).  
- A Solr instance running 8.x loaded with your Nutch data.  You should also configure it with basic security.
- JDK 11
- An SSL certificate stored as a JKS(Optional)

## Additional Links:

- Vue frontend repository - [mversellie/void-engine-vue](https://github.com/mversellie/void-engine-vue)
- Current Deployment - [api.voidengine.io](http://api.voidengine.io)
