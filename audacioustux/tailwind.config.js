const colors = require("tailwindcss/colors");
const {
  screens,
  fontFamily,
  fontSize,
  spacing,
  borderRadius,
  lineHeight,
  minHeight,
} = require("tailwindcss/defaultTheme");

const { pickBy } = require("lodash");

const key2em = (key) => `${key}/em`;
const rem2em = (rem) => rem.replace("rem", "em");
const isRem = (v) => v.endsWith("rem");

const mapEntries = (obj, k_func, v_func) =>
  Object.fromEntries(
    Object.entries(obj).map(([k, v]) => [k_func(k), v_func(v)])
  );

const config = {
  mode: "jit",
  purge: ["./src/main/webapp/**/*.{jsp,html}"],
  plugins: [
    require("tailwindcss-children"),
    require("tailwindcss-pseudo-elements"),
  ],
  darkMode: "class",
  theme: {
    screens: { xs: "320px", ...screens },
    colors: {
      transparent: "transparent",
      current: "currentColor",
      ...colors,
    },
    spacing: {
      ...spacing,
      ...mapEntries(pickBy(spacing, isRem), key2em, rem2em),
    },
    fontFamily: {
      ...fontFamily,
      mono: ['"JetBrains Mono"', ...fontFamily.mono],
      "playfair-serif": ['"Playfair Display"', ...fontFamily.serif],
    },
    borderRadius: {
      ...borderRadius,
      ...mapEntries(pickBy(borderRadius, isRem), key2em, rem2em),
    },
    fontSize: {
      ...fontSize,
      ...mapEntries(
        pickBy(fontSize, ([size]) => isRem(size)),
        key2em,
        (v) => {
          const [size, { lineHeight }] = v;
          return [rem2em(size), { lineHeight: rem2em(lineHeight) }];
        }
      ),
    },
    lineHeight: {
      ...lineHeight,
      ...mapEntries(pickBy(lineHeight, isRem), key2em, rem2em),
    },
    minHeight: { ...minHeight, "vmin-full": "100vmin" },
  },
};

module.exports = config;
