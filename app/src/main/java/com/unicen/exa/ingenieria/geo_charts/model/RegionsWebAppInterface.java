package com.unicen.exa.ingenieria.geo_charts.model;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RegionsWebAppInterface {
    Context mContext;
    private HashMap<String, Integer> result;

    /**
     * Instantiate the interface and set the context
     */
    public RegionsWebAppInterface(Context c, HashMap<String, Integer> result) {
        mContext = c;
        this.result = result;
    }

    /**
     * Show a toast from the web page
     */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public int getSize(){
        int size = result.keySet().size();
        System.out.println(size);
        return size;
    }

    @JavascriptInterface
    public String getInts() {
        Integer[] aux = new Integer[result.keySet().size()];
        int i = 0;
        for (String key : result.keySet()) {
            aux[i] = result.get(key);
            i++;
        }
        return a1dToJson(aux).toString();
    }

    @JavascriptInterface
    public String getStrings() {
        String[] aux = new String[result.keySet().size()];
        int i = 0;
        for (String key : result.keySet()) {
            aux[i] = key;
            i++;
        }
        return aStToJson(aux).toString();
    }

    private String a1dToJson(Integer[] data) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            Integer d = data[i];
            if (i > 0)
                sb.append(",");
            sb.append(d);
        }
        sb.append("]");
        return sb.toString();
    }

    private String checkException(String i) {
        if (todos.contains(i))
            return i;
        String res;
        switch (i) {
            case "Myanmar [Burma]":
                res = "Myanmar";
                break;
            case "Macedonia [FYROM]":
                res = "Macedonia";
                break;
            case "Congo [Republic]":
                res = "Democratic Republic of the Congo";
                break;
            case "Moldavia":
                res = "Moldova";
                break;
            case "Malasia":
                res = "Malaysia";
                break;
            case "Czech Republic":
                res = "Czechia";
                break;
            case "Palestinian Territories":
                res = "Palestine, State of";
                break;
            case "Arabia Saudita":
                res = "Saudi Arabia";
                break;
            case "Bosnia":
                res = "Bosnia and Herzegovina";
                break;
            case "Kosovo":
                res = "Norfolk Island";
                break;
            case "Micronesia":
                res = "Micronesia (Federated States of)";
                break;
            case "Congo [DRC]":
                res = "Congo";
                break;
            default:
                System.out.println(i);
                res = "Unknown";
                break;
        }
        return res;
    }

    private String aStToJson(String[] data) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            String d = data[i];
            d = checkException(d);
            sb.append("\"");
            if (i > 0) {
                sb.append(",");
                sb.append("\"");
            }
            sb.append(d);
        }

        sb.append("\"");
        sb.append("]");
        return sb.toString();
    }

    private ArrayList<String> todos = new ArrayList<>(Arrays.asList(
            "Bhutan", "Democratic Republic of the Congo", "Liechtenstein", "Maldives",
            "Sudan",
            "Zimbabwe",
            "Mauritania",
            "Mozambique",
            "Nigeria",
            "Swaziland",
            "Tanzania",
            "Iraq",
            "Guyana",
            "Namibia",
            "Senegal",
            "Turkmenistan",
            "Afghanistan",
            "Andorra",
            "Fiji",
            "Gabon",
            "Uzbekistan",
            "Cameroon",
            "Cuba",
            "Faroe Islands",
            "El Salvador",
            "Caribbean",
            "Ethiopia",
            "Mongolia",
            "Puerto Rico",
            "Samoa",
            "Myanmar",
            "Nicaragua",
            "Seychelles",
            "Tajikistan",
            "Dominican Republic",
            "Guinea",
            "Barbados",
            "CI",
            "Laos",
            "Libya",
            "Panama",
            "Bahrain",
            "Benin",
            "Ghana",
            "Haiti",
            "Montenegro",
            "Somalia",
            "Syria",
            "Ecuador",
            "Honduras",
            "Madagascar",
            "Papua New Guinea",
            "Tunisia",
            "Angola",
            "Botswana",
            "Cyprus",
            "Algeria",
            "Bahamas",
            "New Caledonia",
            "Uganda",
            "Yemen",
            "Zambia",
            "Antarctica",
            "Paraguay",
            "Jamaica",
            "Palestine",
            "Bolivia",
            "Bosnia and Herzegovina",
            "Vietnam",
            "Kenya",
            "Luxembourg",
            "Niger",
            "Kuwait",
            "Hawaii",
            "Scotland",
            "Cambodia",
            "Uruguay",
            "Kyrgyzstan",
            "Saudi Arabia",
            "Indonesia",
            "Azerbaijan",
            "United Arab Emirates",
            "Mauritius",
            "Morocco",
            "Albania",
            "South Korea",
            "Kazakhstan",
            "Macedonia",
            "Venezuela",
            "Taiwan",
            "Qatar",
            "Jordan",
            "Iceland",
            "Guatemala",
            "Costa Rica",
            "Hong Kong",
            "San Marino",
            "Colombia",
            "Moldova",
            "Armenia",
            "Malta",
            "Nepal",
            "Lebanon",
            "Malaysia",
            "Serbia",
            "Peru",
            "Trinidad and Tobago",
            "Lithuania",
            "Estonia",
            "Georgia",
            "Iran",
            "Chile",
            "Latvia",
            "Thailand",
            "Egypt",
            "Slovenia",
            "Mexico",
            "Belarus",
            "Slovakia",
            "Sri Lanka",
            "Croatia",
            "Philippines",
            "Bangladesh",
            "Turkey",
            "Romania",
            "Italy",
            "South Africa", "Hungary",
            "Pakistan",
            "Portugal",
            "Ukraine",
            "Greece",
            "Oman",
            "Argentina",
            "Singapore",
            "Bulgaria",
            "Japan",
            "Czech Republic ",
            "Ireland",
            "China",
            "Finland",
            "Brazil",
            "Norway",
            "Austria",
            "Denmark",
            "Belgium",
            "New Zealand",
            "Spain",
            "Switzerland",
            "Russia",
            "Poland",
            "Israel",
            "Sweden",
            "Netherlands",
            "France",
            "Australia",
            "Canada",
            "India",
            "Germany",
            "United Kingdom",
            "United States",
            "Unknown",
            "Afghanistan",
            "Åland Islands",
            "Albania",
            "Algeria",
            "American Samoa",
            "Andorra",
            "Angola",
            "Anguilla",
            "Antarctica",
            "Antiguand Barbuda",
            "Argentina",
            "Armenia",
            "Aruba",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bermuda",
            "Bhutan",
            "Bolivia (Plurinational State of)",
            "Bonaire, Sint Eustatius and Saba",
            "Bosnia and Herzegovina",
            "Botswana",
            "Bouvet Island",
            "Brazil",
            "British Indian Ocean Territory",
            "Brunei Darussalam",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cabo Verde",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Cayman Islands",
            "Central African Republic",
            "Chad",
            "Chile",
            "China",
            "Christmas Island",
            "Cocos (Keeling) Islands",
            "Colombia",
            "Comoros",
            "Congo",
            "Congo (Democratic Republic of the)",
            "Cook Islands",
            "Costa Rica",
            "Côte d\'Ivoire",
            "Croatia",
            "Cuba",
            "Curaçao",
            "Cyprus",
            "Czechia",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Ethiopia",
            "Falkland Islands (Malvinas)",
            "Faroe Islands",
            "Fiji",
            "Finland",
            "France",
            "French Guiana",
            "French Polynesia",
            "French Southern Territories",
            "Gabon",
            "Gambia",
            "Georgia",
            "Germany",
            "Ghana",
            "Gibraltar",
            "Greece",
            "Greenland",
            "Grenada",
            "Guadeloupe",
            "Guam",
            "Guatemala",
            "Guernsey",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Heard Island and McDonald Islands",
            "Holy See",
            "Honduras",
            "Hong Kong",
            "Hungary",
            "Iceland",
            "India",
            "Indonesia",
            "Iran (Islamic Republic of)",
            "Iraq",
            "Ireland",
            "Isle of Man",
            "Israel",
            "Italy",
            "Jamaica",
            "Japan",
            "Jersey",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Korea (Democratic People\'s Republic of)",
            "Korea (Republic of)",
            "Kuwait",
            "Kyrgyzstan",
            "Lao People\'s Democratic Republic",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macao",
            "Macedonia (the ormer Yugoslav Republic of)",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands",
            "Martinique",
            "Mauritania",
            "Mauritius",
            "Mayotte",
            "Mexico",
            "Micronesia (Federated States of)",
            "Moldova (Republic of)",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Montserrat",
            "Morocco",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands",
            "New Caledonia",
            "New Zealand",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "Niue",
            "Norfolk Island",
            "Northern Mariana Islands",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Palestine, State of",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Pitcairn",
            "Poland",
            "Portugal",
            "Puerto Rico",
            "Qatar",
            "Réunion",
            "Romania",
            "Russian Federation",
            "Rwanda",
            "Saint Barthélemy",
            "Saint Helena, Ascension and Tristan da Cunha",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Martin (French part)",
            "Saint Pierre and Miquelon",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome and Principe",
            "Saudirabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Sint Maarten (Dutch part)",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Georgia and the South Sandwich Islands",
            "South Sudan",
            "Spain",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Svalbard and Jan Mayen",
            "Swaziland",
            "Sweden",
            "Switzerland",
            "Syrian Arab Republic",
            "Taiwan, Province of China[a]",
            "Tajikistan",
            "Tanzania, United Republic of",
            "Thailand",
            "Timor-Leste",
            "Togo",
            "Tokelau",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Turks and Caicos Islands",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates",
            "United Kingdom of Great Britain and Northern Ireland",
            "United States of America",
            "United States Minor Outlying Islands",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Venezuela (Bolivarian Republic of)",
            "Viet Nam",
            "Virgin Islands (British)",
            "Virgin Islands (U.S.)",
            "Wallis and Futuna",
            "Western Sahara",
            "Yemen",
            "Zambia",
            "Zimbabwe"));

}

