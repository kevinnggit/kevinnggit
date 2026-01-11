import requests
import pandas as pd

# JSON-Daten von der API laden (alternativ CSV)
url = "https://data.lacity.org/api/views/trxm-jn3c/rows.json?accessType=DOWNLOAD"
res = requests.get(url)
data_json = res.json()

# Daten und Spalteninformationen entnehmen
rows = data_json["data"]
col_info = data_json["meta"]["view"]["columns"]
col_names = [col["fieldName"] for col in col_info]

# DataFrame erstellen und Spalten benennen
df = pd.DataFrame(rows, columns=col_names)
# Falls noch interne Spalten vorhanden sind (z.B. :id), diese entfernen:
df = df.loc[:, ~df.columns.str.startswith(":")]

# Alternativ direkt CSV einlesen:
# df = pd.read_csv("https://data.lacity.org/api/views/trxm-jn3c/rows.csv?accessType=DOWNLOAD")

# Erste Zeilen ausgeben
#print(df.head())

#print(df.columns.tolist())
# DataFrame nur mit bestimmten Spalten
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

#df_sel = df[cols]
df_sel = df[cols].copy()

# Sicherstellen, dass alle außer 'month' numerisch sind
for col in cols[1:]:
    df_sel.loc[:, col] = pd.to_numeric(df_sel[col], errors='coerce')
    #df_sel.loc[:, "MonthIndex"] = range(1, len(df_sel) + 1)

# Statistische Auswertung:
for col in cols[1:]:  # [1:] überspringt 'month'
    values = df_sel[col].dropna()
    mean_val = values.mean()
    var_val  = values.var()
    std_val  = values.std()

    print(f"{col}:")
    print(f"  Mittelwert = {mean_val:.1f}")
    print(f"  Varianz    = {var_val:.1f}")
    print(f"  Stdabw.    = {std_val:.1f}\n")

    # Korrelationsmatrix mit pandas
    corr_matrix = df_sel.drop(columns=["month"]).corr()  # Kleingeschriebene Spalte ausschließen
    print(corr_matrix.round(3))

# MonthIndex-Spalte korrekt hinzufügen (vermeidet SettingWithCopyWarning)
df_sel.loc[:, "MonthIndex"] = range(1, len(df_sel) + 1)

# Korrelation von Zeitindex mit jeder Museums-Spalte berechnen
for col in cols[1:]:
    r = df_sel["MonthIndex"].corr(df_sel[col], method='pearson')
    print(f"Kor(Time, {col}) = {r:.3f}")


#Nur zum Testen##df_sel.loc[:, "MonthIndex"] = range(1, len(df_sel) + 1)
#Nur zum Testen##df_sel = df[cols].copy()  # Kopie erzeugen
# Spalte sicher einfügen
#Nur zum Testen##df_sel["MonthIndex"] = range(1, len(df_sel) + 1)
