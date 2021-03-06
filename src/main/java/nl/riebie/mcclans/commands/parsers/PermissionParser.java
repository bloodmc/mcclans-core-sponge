/*
 * Copyright (c) 2016 riebie, Kippers <https://bitbucket.org/Kippers/mcclans-core-sponge>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package nl.riebie.mcclans.commands.parsers;


import nl.riebie.mcclans.ClansImpl;
import nl.riebie.mcclans.api.permissions.ClanPermission;
import nl.riebie.mcclans.api.permissions.ClanPermissionManager;
import nl.riebie.mcclans.commands.filledparameters.NormalFilledParameter;
import org.spongepowered.api.command.CommandSource;

/**
 * Created by riebie on 17/01/2016.
 */
public class PermissionParser implements ParameterParser<ClanPermission> {

    @Override
    public ParseResult<ClanPermission> parseValue(CommandSource commandSource, String value, NormalFilledParameter parameter) {
        ClanPermissionManager clanPermissionManager = ClansImpl.getInstance().getClanPermissionManager();
        if (clanPermissionManager.isActiveClanPermission(value)) {
            return ParseResult.newSuccessResult(clanPermissionManager.getClanPermission(value));
        } else {
            return ParseResult.newErrorResult(String.format("%s is not a valid permission", value));
        }

    }

    @Override
    public String getDescription() {
        return "permission";
    }
}
