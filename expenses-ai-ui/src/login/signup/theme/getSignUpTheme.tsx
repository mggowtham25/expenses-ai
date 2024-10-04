import type {} from "@mui/material/themeCssVarsAugmentation";
import { ThemeOptions, PaletteMode } from "@mui/material/styles";
import { getDesignTokens } from "../../../common/themePrimitives";
import { inputsCustomizations } from "../../../common/customizations/inputs";
import { dataDisplayCustomizations } from "../../../common/customizations/dataDisplay";
import { feedbackCustomizations } from "../../../common/customizations/feedback";
import { navigationCustomizations } from "../../../common/customizations/navigation";
import { surfacesCustomizations } from "../../../common/customizations/surfaces";

export default function getSignUpTheme(mode: PaletteMode): ThemeOptions {
    return {
        ...getDesignTokens(mode),
        components: {
            ...inputsCustomizations,
            ...dataDisplayCustomizations,
            ...feedbackCustomizations,
            ...navigationCustomizations,
            ...surfacesCustomizations
        }
    };
}
