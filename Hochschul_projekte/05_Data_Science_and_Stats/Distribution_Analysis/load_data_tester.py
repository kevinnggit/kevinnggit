import requests
import pandas as pd
import matplotlib.pyplot as plt

# Daten von API laden
url = "https://data.lacity.org/api/views/trxm-jn3c/rows.json?accessType=DOWNLOAD"
res = requests.get(url)
data_json = res.json()

# Daten extrahieren
rows = data_json["data"]
col_info = data_json["meta"]["view"]["columns"]
col_names = [col["fieldName"] for col in col_info]

# DataFrame aufbauen
df = pd.DataFrame(rows, columns=col_names)
df = df.loc[:, ~df.columns.str.startswith(":")]

# Relevante Spalten
cols = [
    'month',
    'avila_adobe',
    'firehouse_museum',
    'chinese_american_museum',
    'america_tropical_interpretive_center',
    'iamla',
    'hellman_quon',
    'museum_of_social_justice'
]

# Auswahl + Konvertierung
df_sel = df[cols].copy()
for col in cols[1:]:
    df_sel[col] = pd.to_numeric(df_sel[col], errors='coerce')

# Monat als Datum
df_sel['month'] = pd.to_datetime(df_sel['month'], errors='coerce')

# 📊 Histogramm für Avila Adobe
plt.hist(df_sel["avila_adobe"].dropna(), bins=10, color='skyblue', edgecolor='black')
plt.title("Avila Adobe – Verteilung der Monatsbesucher")
plt.xlabel("Besucher pro Monat")
plt.ylabel("Häufigkeit")
plt.show()

# 📈 Liniendiagramm über Zeit
plt.plot(df_sel["month"], df_sel["avila_adobe"], marker='o', color='green')
plt.title("Avila Adobe – Besucher über die Zeit")
plt.xlabel("Monat")
plt.ylabel("Besucher")
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

# 🟣 Scatterplot: Avila Adobe vs. America Tropical
plt.scatter(
    df_sel["avila_adobe"],
    df_sel["america_tropical_interpretive_center"],
    alpha=0.7,
    color='purple'
)
plt.title("Avila Adobe vs. America Tropical – Besucherzahlen")
plt.xlabel("Avila Adobe Besucher")
plt.ylabel("America Tropical IC Besucher")
plt.grid(True)
plt.show()