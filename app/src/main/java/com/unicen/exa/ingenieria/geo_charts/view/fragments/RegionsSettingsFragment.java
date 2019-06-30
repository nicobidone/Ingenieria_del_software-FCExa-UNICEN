package com.unicen.exa.ingenieria.geo_charts.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.unicen.exa.ingenieria.R;

public class RegionsSettingsFragment extends Fragment {

    private RegionsViewModel model;

    private String countries[] = {"Afghanistan", "Åland Islands", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
            "Antarctica",
            "Antiguand Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
            "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia (Plurinational State of)",
            "Bonaire, Sint Eustatius and Saba", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
            "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Cayman Islands",
            "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros",
            "Congo", "Congo (Democratic Republic of the)", "Cook Islands", "Costa Rica", "Côte d\'Ivoire", "Croatia", "Cuba", "Curaçao",
            "Cyprus", "Czechia", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador",
            "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland",
            "France", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany",
            "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau",
            "Guyana", "Haiti", "Heard Island and McDonald Islands", "Holy See", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
            "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey",
            "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea (Democratic People\'s Republic of)", "Korea (Republic of)", "Kuwait",
            "Kyrgyzstan", "Lao People\'s Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein",
            "Lithuania", "Luxembourg", "Macao", "Macedonia (the ormer Yugoslav Republic of)", "Madagascar", "Malawi", "Malaysia",
            "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico",
            "Micronesia (Federated States of)", "Moldova (Republic of)", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco",
            "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Caledonia", "New Zealand", "Nicaragua", "Niger",
            "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Palestine, State of",
            "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar",
            "Réunion", "Romania", "Russian Federation", "Rwanda", "Saint Barthélemy", "Saint Helena, Ascension and Tristan da Cunha",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin (French part)", "Saint Pierre and Miquelon",
            "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudirabia", "Senegal", "Serbia",
            "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten (Dutch part)", "Slovakia", "Slovenia", "Solomon Islands", "Somalia",
            "South Africa", "South Georgia and the South Sandwich Islands", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname",
            "Svalbard and Jan Mayen", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China[a]",
            "Tajikistan", "Tanzania, United Republic of", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago",
            "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
            "United Kingdom of Great Britain and Northern Ireland", "United States of America", "United States Minor Outlying Islands",
            "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela (Bolivarian Republic of)", "Viet Nam", "Virgin Islands (British)",
            "Virgin Islands (U.S.)", "Wallis and Futuna", "Western Sahara", "Yemen", "Zambia", "Zimbabwe"};

    private String continents[] = {"Africa", "Europe", "Americas", "Asia", "Oceania"};
    private String continents_id[] = {"002", "150", "019", "142", "009"};
    private String subcontinents[] = {
            "Northern Africa", "Western Africa","Middle Africa", "Eastern Africa", "Southern Africa",
            "Northern Europe", "Western Europe", "Eastern Europe", "Southern Europe",
            "Northern America", "Caribbean", "Central America", "South America",
            "Central Asia", "Eastern Asia", "Southern Asia", "Eastern Asia", "Western Asia",
            "Australia and New Zealand", "Melanesia", "Micronesia", "Polynesia"};
    private String subcontinents_id[] = {
            "015", "011", "017", "014", "018",
            "154", "155", "151", "039",
            "021", "029", "013", "005",
            "143", "030", "034", "035", "145",
            "053", "054", "057", "061"};
    private String conutries[] = {
            "DZ", "EG", "EH", "LY", "MA", "SD", "SS", "TN",
            "BF", "BJ", "CI", "CV", "GH", "GM", "GN", "GW", "LR", "ML", "MR", "NE", "NG", "SH", "SL", "SN", "TG",
            "AO", "CD", "ZR", "CF", "CG", "CM", "GA", "GQ", "ST", "TD",
            "BI", "DJ", "ER", "ET", "KE", "KM", "MG", "MU", "MW", "MZ", "RE", "RW", "SC", "SO", "TZ", "UG", "YT", "ZM", "ZW",
            "BW", "LS", "NA", "SZ", "ZA",
            "GG", "JE", "AX", "DK", "EE", "FI", "FO", "GB", "IE", "IM", "IS", "LT", "LV", "NO", "SE", "SJ",
            "AT", "BE", "CH", "DE", "DD", "FR", "FX", "LI", "LU", "MC", "NL",
            "BG", "BY", "CZ", "HU", "MD", "PL", "RO", "RU", "SU", "SK", "UA",
            "AD", "AL", "BA", "ES", "GI", "GR", "HR", "IT", "ME", "MK", "MT", "CS", "RS", "PT", "SI", "SM", "VA", "YU",
            "BM", "CA", "GL", "PM", "US",
            "AG", "AI", "AN", "AW", "BB", "BL", "BS", "CU", "DM", "DO", "GD", "GP", "HT", "JM", "KN", "KY", "LC", "MF", "MQ", "MS", "PR",
            "TC", "TT", "VC", "VG", "VI",
            "BZ", "CR", "GT", "HN", "MX", "NI", "PA", "SV",
            "AR", "BO", "BR", "CL", "CO", "EC", "FK", "GF", "GY", "PE", "PY", "SR", "UY", "VE",
            "TM", "TJ", "KG", "KZ", "UZ",
            "CN", "HK", "JP", "KP", "KR", "MN", "MO", "TW",
            "AF", "BD", "BT", "IN", "IR", "LK", "MV", "NP", "PK",
            "BN", "ID", "KH", "LA", "MM", "BU", "MY", "PH", "SG", "TH", "TL", "TP", "VN",
            "AE", "AM", "AZ", "BH", "CY", "GE", "IL", "IQ", "JO", "KW", "LB", "OM", "PS", "QA", "SA", "NT", "SY", "TR", "YE", "YD",
            "AU", "NF", "NZ",
            "FJ", "NC", "PG", "SB", "VU",
            "FM", "GU", "KI", "MH", "MP", "NR", "PW",
            "AS", "CK", "NU", "PF", "PN", "TK", "TO", "TV", "WF", "WS"};


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_regions_settings, container, false);
        Button button = view.findViewById(R.id.button2);

        if (getActivity() != null) {
            model = ViewModelProviders.of(getActivity()).get(RegionsViewModel.class);
            button.setOnClickListener(v -> model.select(true));
        }

        return view;
    }


}
