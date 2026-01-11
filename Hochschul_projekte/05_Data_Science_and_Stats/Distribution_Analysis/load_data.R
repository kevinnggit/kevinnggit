# Script to load data from the Los Angeles data portal

# Load required package
library(jsonlite)

# JSON data URL (optionally download CSV directly instead)
json_url <- "https://data.lacity.org/api/views/trxm-jn3c/rows.json?accessType=DOWNLOAD"
raw <- fromJSON(json_url)

# The actual data reside in raw$data, column info in raw$meta
# Convert to data frame and assign column names from metadata
df <- as.data.frame(raw$data)
colnames(df) <- raw$meta$view$columns$fieldName

# Alternatively, you can load the CSV version directly:
# df <- read.csv("https://data.lacity.org/api/views/trxm-jn3c/rows.csv?accessType=DOWNLOAD")

# Inspect the first entries
head(df)
