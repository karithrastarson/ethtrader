# eth trader
Exploring the capabilities of Kraken API. Gathering data about trades on Kraken. Potentially use this data to create orders.

The inital functionality is as follows: Query kraken, and get the price of the latest trades of the following pairs:

* Bitcoin/EUR
* Bitcoin Cash/EUR
* Etherum/EUR

Output the results to a file called prices.txt in the following format:


date (ddMMyyyy_HHmmss) | XBT/EUR | ETH/EUR | BCH/EUR | 
--- | --- | --- | --- |
TIMESTAMP | Double | Double | Double | 
